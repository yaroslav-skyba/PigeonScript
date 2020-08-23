package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BoolExpressionTokenInterpreter extends SpecificExpressionTokenInterpreter<Boolean> {

    @Autowired
    public BoolExpressionTokenInterpreter(PomidorTokenType operandType) {

        super(operandType);
    }

    @Override
    public Boolean[] getExpressionOperands(List<PomidorToken> expressionTokens) {

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
    public Boolean calculateExpression(List<PomidorToken> expressionTokens, Boolean[] expressionOperands) {

        final int operandsLength = expressionOperands.length;
        boolean result = expressionOperands[0];

        if (operandsLength == 1) {

            return result;
        }

        for (int i = 1; i < operandsLength; i++) {

            final int firstExpressionOperationIndex = 1;
            final int operandIndex = i * 2;

            switch (expressionTokens.get(operandIndex - firstExpressionOperationIndex).getSourceCode()) {

                case "&":
                    result &= expressionOperands[operandIndex];
                    break;
                case "|":
                    result |= expressionOperands[operandIndex];
                    break;
                default:
                    return null;
            }
        }

        return result;
    }
}