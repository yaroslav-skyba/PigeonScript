package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class IntExpressionTokenInterpreter extends SpecificExpressionTokenInterpreter<Long> {

    @Autowired
    protected IntExpressionTokenInterpreter(PomidorTokenType operandType) {

        super(operandType);
    }

    @Override
    public Long[] getExpressionOperands(List<PomidorToken> expressionTokens) {

        final String[] sourceCodeOperands = getSourceCodeOperands(expressionTokens);
        final int expressionOperandsLength = sourceCodeOperands.length;
        final Long[] intOperands = new Long[expressionOperandsLength];

        for (int i = 0; i < expressionOperandsLength; i++) {

            intOperands[i] = Long.parseLong(sourceCodeOperands[i]);
        }

        return intOperands;
    }

    @Override
    public Long calculateExpression(List<PomidorToken> expressionTokens, Long[] expressionOperands) {

        Long result = expressionOperands[0];
        final int operandsLength = expressionOperands.length;

        if (operandsLength == 1) {

            return result;
        }

        for (int i = 1; i < operandsLength; i++) {

            final int firstExpressionOperationIndex = 1;
            final int operandIndex = i * 2;

            switch (expressionTokens.get(operandIndex - firstExpressionOperationIndex).getSourceCode()) {

                case "+":
                    result += expressionOperands[operandIndex];
                    break;
                case "-":
                    result -= expressionOperands[operandIndex];
                    break;
                case "*":
                    result *= expressionOperands[operandIndex];
                    break;
                case "/":
                    result /= expressionOperands[operandIndex];
                    break;
                default:
                    return null;
            }
        }

        return result;
    }
}