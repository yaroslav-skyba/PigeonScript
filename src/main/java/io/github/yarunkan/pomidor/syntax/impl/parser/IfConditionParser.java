package io.github.yarunkan.pomidor.syntax.impl.parser;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.TokenImpl;
import io.github.yarunkan.pomidor.syntax.token.TokenParser;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class IfConditionParser implements TokenParser {

    @Autowired
    private TokenType ifConditionType;

    private final TokenParser keywordParser;
    private final TokenParser expressionParser;

    @Autowired
    public IfConditionParser(TokenParser keywordParser,
                             TokenParser expressionParser) {

        this.keywordParser = keywordParser;
        this.expressionParser = expressionParser;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokensList = new ArrayList<>();

        tokensList.add(keywordParser.parse(sourceCodeTokens[0]));

        final int tokensCount = sourceCodeTokens.length;
        final int expressionTokensCount = tokensCount - 2;
        final String[] expressionTokens = new String[expressionTokensCount];

        final int expressionTokensOffset = 1;

        System.arraycopy(sourceCodeTokens, expressionTokensOffset, expressionTokens, 0, expressionTokensCount);

        tokensList.addAll(expressionParser.parse(expressionTokens).getSubTokens());
        tokensList.add(keywordParser.parse(sourceCodeTokens[tokensCount - expressionTokensOffset]));

        return new TokenImpl(ifConditionType, String.join(" ", sourceCodeTokens), tokensList);
    }
}