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
public class OperationParser implements TokenParser {

    @Autowired
    private TokenType operationType;

    private final TokenParser operandParser;
    private final TokenParser operatorParser;
    private final TokenParser expressionParser;

    @Autowired
    public OperationParser(TokenParser operandParser,
                           TokenParser operatorParser,
                           TokenParser expressionParser) {

        this.operandParser = operandParser;
        this.operatorParser = operatorParser;
        this.expressionParser = expressionParser;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokensList = new ArrayList<>();

        tokensList.add(operandParser.parse(sourceCodeTokens[0]));
        tokensList.add(operatorParser.parse(sourceCodeTokens[1]));

        final int notExpressionTokensCount = 2;
        final int expressionTokensCount = sourceCodeTokens.length - notExpressionTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, notExpressionTokensCount, expressionTokens, 0, expressionTokensCount);

        tokensList.addAll(expressionParser.parse(expressionTokens).getSubTokens());

        return new TokenImpl(operationType, String.join(" ", sourceCodeTokens), tokensList);
    }
}