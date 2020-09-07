package io.github.yarunkan.pomidor.syntax.impl.parser;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.TokenImpl;
import io.github.yarunkan.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class PrintCommandParser implements TokenParser {

    private final TokenType printCommandType;
    private final TokenParser keywordParser;
    private final TokenParser expressionParser;

    @Autowired
    public PrintCommandParser(TokenParser expressionParser, @Lazy TokenType printCommandType, @Lazy TokenParser keywordParser) {

        this.expressionParser = expressionParser;
        this.printCommandType = printCommandType;
        this.keywordParser = keywordParser;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokenList = new ArrayList<>();

        tokenList.add(keywordParser.parse(sourceCodeTokens[0]));

        final int notExpressionTokensCount = 1;
        final int expressionTokensCount = sourceCodeTokens.length - notExpressionTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, notExpressionTokensCount, expressionTokens, 0, expressionTokensCount);

        tokenList.addAll(expressionParser.parse(expressionTokens).getSubTokens());

        return new TokenImpl(printCommandType, String.join(" ", sourceCodeTokens), tokenList);
    }
}