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
public class OperationParser implements TokenParser {

    private final TokenType operationType;
    private final TokenParser operandParser;
    private final TokenParser operatorParser;
    private final TokenParser expressionParser;

    @Autowired
    public OperationParser(TokenParser operandParser,
                           TokenParser operatorParser,
                           TokenParser expressionParser,
                           @Lazy TokenType operationType) {

        this.operandParser = operandParser;
        this.operatorParser = operatorParser;
        this.expressionParser = expressionParser;
        this.operationType = operationType;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokenList = new ArrayList<>();

        tokenList.add(operandParser.parse(sourceCodeTokens[0]));
        tokenList.add(operatorParser.parse(sourceCodeTokens[1]));

        final int notExpressionTokensCount = 2;
        final int expressionTokensCount = sourceCodeTokens.length - notExpressionTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, notExpressionTokensCount, expressionTokens, 0, expressionTokensCount);

        tokenList.addAll(expressionParser.parse(expressionTokens).getSubTokens());

        return new TokenImpl(operationType, String.join(" ", sourceCodeTokens), tokenList);
    }
}