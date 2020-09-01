package io.github.mchuhaievskyi.pomidor.syntax.impl.parser;

import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.impl.TokenImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class PrintCommandParser implements TokenParser {

    @Autowired
    private TokenType printCommandType;
    @Autowired
    private TokenParser keywordParser;

    private final TokenParser expressionParser;

    @Autowired
    public PrintCommandParser(TokenParser expressionParser) {

        this.expressionParser = expressionParser;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokensList = new ArrayList<>();

        tokensList.add(keywordParser.parse(sourceCodeTokens[0]));

        final int notExpressionTokensCount = 1;
        final int expressionTokensCount = sourceCodeTokens.length - notExpressionTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, notExpressionTokensCount, expressionTokens, 0, expressionTokensCount);

        tokensList.addAll(expressionParser.parse(expressionTokens).getSubTokens());

        return new TokenImpl(printCommandType, String.join(" ", sourceCodeTokens), tokensList);
    }
}