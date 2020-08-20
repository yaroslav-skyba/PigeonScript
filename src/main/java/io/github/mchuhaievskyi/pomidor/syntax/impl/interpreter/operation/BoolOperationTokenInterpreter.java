package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation;

import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;

@Component
public class BoolOperationTokenInterpreter extends SpecificOperationTokenInterpreter<Boolean> {

    private final PomidorVariablesDatabase variablesDatabase = PomidorVariablesDatabaseImpl.getInstance();

    @Override
    public boolean interpret(PomidorToken token) {

        if (!super.interpret(token)) {

            return false;
        }

        final List<PomidorToken> subTokens = token.getSubTokens();
        final String assignableVarName = subTokens.get(0).getSourceCode();
        final int operandsCount = subTokens.size() / 2;
        final int firstOperandPosition = 2;
        final Boolean[] boolOperands = getOperands(subTokens, operandsCount, firstOperandPosition);

        if (boolOperands == null) {

            return false;
        }

        final Boolean calculationResult = calculateOperands(subTokens, boolOperands, 3);

        if (calculationResult == null) {

            return false;
        }

        variablesDatabase.setVariable(assignableVarName, calculationResult.toString());

        return true;
    }

    @Override
    public Boolean[] getOperands(List<PomidorToken> subTokens, int operandsCount, int firstOperandIndex) {

        final String[] stringOperands = new String[operandsCount];
        final Boolean[] boolOperands = new Boolean[operandsCount];

        for (int i = 0; i < operandsCount; i++) {

            stringOperands[i] = subTokens.get(i * 2 + firstOperandIndex).getSourceCode();
            stringOperands[i] = Objects.requireNonNullElse(variablesDatabase.getVariable(stringOperands[i]), stringOperands[i]);

            if (stringOperands[i].equals("true")) {

                boolOperands[i] = true;

            } else if (stringOperands[i].equals("false")) {

                boolOperands[i] = false;

            } else {

                return null;
            }
        }

        return boolOperands;
    }

    @Override
    public Boolean calculateOperands(List<PomidorToken> subTokens, Boolean[] operands, int firstOperationIndex) {

        final int operandsCount = operands.length;
        boolean result = operands[0];

        if (operandsCount == 1) {

            return result;
        }
        final int operandsOffset = 1;

        for (int i = 0; i < operandsCount - operandsOffset; i++) {

            final int operandsArrayIndex = i + operandsOffset;

            switch (subTokens.get(i * 2 + firstOperationIndex).getSourceCode()) {

                case "&":
                    result &= operands[operandsArrayIndex];
                    break;
                case "|":
                    result |= operands[operandsArrayIndex];
                    break;
                default:
                    return null;
            }
        }

        return result;
    }
}