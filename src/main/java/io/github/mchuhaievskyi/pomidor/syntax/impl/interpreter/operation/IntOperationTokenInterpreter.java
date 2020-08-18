package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation;

import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;

@Component
public class IntOperationTokenInterpreter extends SpecificOperationTokenInterpreter<Long> {

    private final PomidorVariablesDatabase variablesDatabase = PomidorVariablesDatabaseImpl.getInstance();

    @Override
    public boolean interpret(PomidorToken token) {

        if (!super.interpret(token)) {

            return false;
        }

        final List<PomidorToken> subTokens = token.getSubTokens();
        final String assignableVarName = subTokens.get(0).getSourceCode();
        final Long[] operands;
        final int operandsCount = subTokens.size() / 2;

        try {

            final int firstOperandPosition = 2;
            operands = getOperands(subTokens, operandsCount, firstOperandPosition);

        } catch (NumberFormatException e) {

            return false;
        }

        final Long calculationResult = calculateOperands(subTokens, operands, 3);

        if (calculationResult == null) {

            return false;
        }

        variablesDatabase.setVariable(assignableVarName, calculationResult.toString());

        return true;
    }

    @Override
    public Long[] getOperands(List<PomidorToken> subTokens, int operandsCount, int firstOperandPosition) {

        final String[] stringOperands = new String[operandsCount];
        final Long[] intOperands = new Long[operandsCount];

        for (int i = 0; i < operandsCount; i++) {

            stringOperands[i] = subTokens.get(i*2+firstOperandPosition).getSourceCode();
            stringOperands[i] = Objects.requireNonNullElse(variablesDatabase.getVariable(stringOperands[i]), stringOperands[i]);
            intOperands[i] = Long.parseLong(stringOperands[i]);
        }

        return intOperands;
    }

    @Override
    public Long calculateOperands(List<PomidorToken> subTokens, Long[] operands, int firstOperationPosition) {

        Long result = operands[0];
        final int operandsCount = operands.length;

        if (operandsCount == 1) {

            return result;
        }

        final int operandsOffset = 1;

        for (int i = 0; i < operandsCount - operandsOffset; i++) {

            final int operandsArrayIndex = i + operandsOffset;

            switch (subTokens.get(i * 2 + firstOperationPosition).getSourceCode()) {

                case "+":
                    result += operands[operandsArrayIndex];
                    break;
                case "-":
                    result -= operands[operandsArrayIndex];
                    break;
                case "*":
                    result *= operands[operandsArrayIndex];
                    break;
                case "/":
                    result /= operands[operandsArrayIndex];
                    break;
                default:
                    return null;
            }
        }

        return result;
    }
}