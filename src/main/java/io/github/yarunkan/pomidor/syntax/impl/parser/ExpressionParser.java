package io.github.yarunkan.pomidor.syntax.impl.parser;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.TokenImpl;
import io.github.yarunkan.pomidor.syntax.token.TokenParser;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class ExpressionParser implements TokenParser {

    private final TokenType expressionType;
    private final TokenParser operandParser;
    private final TokenParser operatorParser;

    @Autowired
    public ExpressionParser(@Lazy TokenParser operandParser, TokenParser operatorParser, TokenType expressionType) {

        this.operandParser = operandParser;
        this.operatorParser = operatorParser;
        this.expressionType = expressionType;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokenList = new ArrayList<>();

        tokenList.add(operandParser.parse(sourceCodeTokens[0]));

        for (int i = 1; i < sourceCodeTokens.length; i += 2) {

            tokenList.add(operatorParser.parse(sourceCodeTokens[i]));
            tokenList.add(operandParser.parse(sourceCodeTokens[i+1]));
        }

        return new TokenImpl(expressionType, String.join(" ", sourceCodeTokens), tokenList);
    }
}