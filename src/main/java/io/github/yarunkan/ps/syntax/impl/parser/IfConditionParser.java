package io.github.yarunkan.ps.syntax.impl.parser;

import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.impl.TokenImpl;
import io.github.yarunkan.ps.syntax.token.TokenParser;
import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class IfConditionParser implements TokenParser {

    private final TokenType ifConditionType;
    private final TokenParser keywordParser;
    private final TokenParser expressionParser;

    @Autowired
    public IfConditionParser(TokenParser keywordParser, TokenParser expressionParser, @Lazy TokenType ifConditionType) {

        this.keywordParser = keywordParser;
        this.expressionParser = expressionParser;
        this.ifConditionType = ifConditionType;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokenList = new ArrayList<>();

        tokenList.add(keywordParser.parse(sourceCodeTokens[0]));

        final int tokensCount = sourceCodeTokens.length;
        final int expressionTokensCount = tokensCount - 2;
        final String[] expressionTokens = new String[expressionTokensCount];

        final int expressionTokensOffset = 1;

        System.arraycopy(sourceCodeTokens, expressionTokensOffset, expressionTokens, 0, expressionTokensCount);

        tokenList.addAll(expressionParser.parse(expressionTokens).getSubTokens());
        tokenList.add(keywordParser.parse(sourceCodeTokens[tokensCount - expressionTokensOffset]));

        return new TokenImpl(ifConditionType, String.join(" ", sourceCodeTokens), tokenList);
    }
}