package io.github.yarunkan.pomidor.syntax.impl.interpreter.expression;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BoolExpressionInterpreter extends SpecificExpressionInterpreter<Boolean> {

    @Autowired
    public BoolExpressionInterpreter(TokenType operandType, TokenType operatorType) {

        super(operandType, operatorType);
    }

    @Override
    Boolean[] getExpressionOperands(List<Token> expressionTokens) {

        final String[] sourceCodeOperands = getSourceCodeOperands(expressionTokens);
        final int expressionOperandsLength = sourceCodeOperands.length;
        final Boolean[] boolOperands = new Boolean[expressionOperandsLength];

        for (int i = 0; i < expressionOperandsLength; i++) {

            if (sourceCodeOperands[i].equals("true")) {

                boolOperands[i] = true;

            } else if (sourceCodeOperands[i].equals("false")) {

                boolOperands[i] = false;

            } else {

                return null;
            }
        }

        return boolOperands;
    }

    @Override
    Boolean calculateExpression(String[] expressionOperators, Boolean[] expressionOperands) {

        boolean result = expressionOperands[0];

        if (expressionOperands.length == 1) {

            return result;
        }

        for (int i = 0; i < expressionOperators.length; i++) {

            final int operandsOffset = 1;

            switch (expressionOperators[i]) {

                case "&":
                    result &= expressionOperands[i + operandsOffset];
                    break;
                case "|":
                    result |= expressionOperands[i + operandsOffset];
                    break;
                default:
                    return null;
            }
        }

        return result;
    }
}