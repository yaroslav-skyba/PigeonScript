package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation;

import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import java.util.List;

public abstract class SpecificOperationTokenInterpreter<T> extends PomidorTokenInterpreter {

    public abstract T[] getOperands(List<PomidorToken> subTokens, int operandsCount, int firstOperandIndex);
    public abstract T calculateOperands(List<PomidorToken> subTokens, T[] operands, int firstOperationIndex);

    @Override
    public boolean interpret(PomidorToken token) {

        final List<PomidorToken> subTokens = token.getSubTokens();
        final String assignableVarName = subTokens.get(0).getSourceCode();
        final PomidorVariablesDatabase variablesDatabase = PomidorVariablesDatabaseImpl.getInstance();
        final String assignableVarValue = variablesDatabase.getVariable(assignableVarName);

        return assignableVarValue != null;
    }
}