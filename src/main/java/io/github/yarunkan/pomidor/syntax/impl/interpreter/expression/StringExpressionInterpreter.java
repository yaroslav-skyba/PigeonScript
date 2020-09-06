package io.github.yarunkan.pomidor.syntax.impl.interpreter.expression;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StringExpressionInterpreter extends SpecificExpressionInterpreter<String> {

    private static final String QUOTE = "\"";
    private static final CharSequence EMPTY = "";

    @Autowired
    protected StringExpressionInterpreter(TokenType operandType, TokenType operatorType) {

        super(operandType, operatorType);
    }

    @Override
    public String[] getExpressionOperands(List<Token> expressionTokens) {

        return getSourceCodeOperands(expressionTokens);
    }

    @Override
    public String calculateExpression(String[] expressionOperators, String[] expressionOperands) {

        if (expressionOperands.length == 1) {

            return expressionOperands[0];
        }

        return QUOTE + String.join(EMPTY, expressionOperands).replace(QUOTE, EMPTY) + QUOTE;
    }
}