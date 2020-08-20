package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.print;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation.SpecificOperationTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import java.util.List;

public abstract class SpecificPrintCommandTokenInterpreter<T> extends PomidorTokenInterpreter {

    private final SpecificOperationTokenInterpreter<T> specificOperationTokenInterpreter;

    public SpecificPrintCommandTokenInterpreter(SpecificOperationTokenInterpreter<T> specificOperationTokenInterpreter) {

        this.specificOperationTokenInterpreter = specificOperationTokenInterpreter;
    }

    @Override
    public boolean interpret(PomidorToken token) {

        final List<PomidorToken> subTokens = token.getSubTokens();
        final int tokenOperandsCount = subTokens.size() / 2;
        final T[] tokenOperands;
        final int firstTokenOperationIndex = 2;
        final T result;

        try {

            tokenOperands = specificOperationTokenInterpreter.getOperands(subTokens, tokenOperandsCount, 1);
            result = specificOperationTokenInterpreter.calculateOperands(subTokens, tokenOperands, firstTokenOperationIndex);

        } catch (RuntimeException e) {

            return false;
        }

        printInterpretationResult(result);

        return true;
    }

    void printInterpretationResult(T result) {

        System.out.println(result);
    }
}