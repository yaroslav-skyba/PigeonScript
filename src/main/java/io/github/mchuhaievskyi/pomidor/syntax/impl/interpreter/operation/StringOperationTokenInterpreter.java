package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation;

import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;

@Component
public class StringOperationTokenInterpreter extends SpecificOperationTokenInterpreter<String> {

    private final PomidorVariablesDatabase variablesDatabase = PomidorVariablesDatabaseImpl.getInstance();
    private static final String QUOTE = "\"";
    private static final String EMPTY = "";

    @Override
    public boolean interpret(PomidorToken token) {

        if (!super.interpret(token)) {

            return false;
        }

        final List<PomidorToken> subTokens = token.getSubTokens();
        final int operandsCount = subTokens.size() / 2;
        final int firstOperandPosition = 2;
        final String[] operands = getOperands(subTokens, operandsCount, firstOperandPosition);
        final String result = calculateOperands(subTokens, operands, -1);
        final String assignableVarName = subTokens.get(0).getSourceCode();

        variablesDatabase.setVariable(assignableVarName, result);

        return true;
    }

    @Override
    public String[] getOperands(List<PomidorToken> subTokens, int operandsCount, int firstOperandPosition) {

        final String[] operands = new String[operandsCount];

        for (int i = 0; i < operandsCount; i++) {

            operands[i] = subTokens.get(i * 2 + firstOperandPosition).getSourceCode();
            operands[i] = Objects.requireNonNullElse(variablesDatabase.getVariable(operands[i]), operands[i]).replace(QUOTE, EMPTY);
        }

        return operands;
    }

    @Override
    public String calculateOperands(List<PomidorToken> subTokens, String[] operands, int firstOperationPosition) {

        if (operands.length == 1) {

            return QUOTE + operands[0] + QUOTE;
        }

        final String result = QUOTE + String.join(EMPTY, operands);

        return result + QUOTE;
    }
}