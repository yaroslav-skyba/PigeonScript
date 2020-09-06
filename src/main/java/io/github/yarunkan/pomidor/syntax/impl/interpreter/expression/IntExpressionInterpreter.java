package io.github.yarunkan.pomidor.syntax.impl.interpreter.expression;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class IntExpressionInterpreter extends SpecificExpressionInterpreter<Long> {

    @Autowired
    protected IntExpressionInterpreter(TokenType operandType, TokenType operatorType) {

        super(operandType, operatorType);
    }

    @Override
    public Long[] getExpressionOperands(List<Token> expressionTokens) {

        final String[] sourceCodeOperands = getSourceCodeOperands(expressionTokens);
        final int expressionOperandsLength = sourceCodeOperands.length;
        final Long[] intOperands = new Long[expressionOperandsLength];

        for (int i = 0; i < expressionOperandsLength; i++) {

            intOperands[i] = Long.parseLong(sourceCodeOperands[i]);
        }

        return intOperands;
    }

    @Override
    public Long calculateExpression(String[] expressionOperators, Long[] expressionOperands) {

        Long result = expressionOperands[0];

        if (expressionOperands.length == 1) {

            return result;
        }

        for (int i = 0; i < expressionOperators.length; i++) {

            final int operandOffset = 1;

            switch (expressionOperators[i]) {

                case "+":
                    result += expressionOperands[i + operandOffset];
                    break;
                case "-":
                    result -= expressionOperands[i + operandOffset];
                    break;
                case "*":
                    result *= expressionOperands[i + operandOffset];
                    break;
                case "/":
                    result /= expressionOperands[i + operandOffset];
                    break;
                default:
                    return null;
            }
        }

        return result;
    }
}