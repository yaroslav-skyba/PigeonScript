package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression;

import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Objects;

public abstract class SpecificExpressionTokenInterpreter<T> extends PomidorTokenInterpreter {

    final PomidorVariablesDatabase variablesDatabase = PomidorVariablesDatabaseImpl.getInstance();

    private final PomidorTokenType operandType;
    private T expressionResult;

    @Autowired
    protected SpecificExpressionTokenInterpreter(PomidorTokenType operandType) {

        this.operandType = operandType;
    }

    @Override
    public boolean interpret(PomidorToken token) {

        try {

            final List<PomidorToken> subTokens = token.getSubTokens();
            expressionResult = calculateExpression(subTokens, getExpressionOperands(subTokens));

        } catch (RuntimeException e) {

            return false;
        }

        return true;
    }

    public T getExpressionResult(PomidorToken token) {

        if (!interpret(token)) {

            throw new IllegalStateException("Can not interpret an expression");
        }

        return expressionResult;
    }

    String[] getSourceCodeOperands(List<PomidorToken> expressionTokens) {

        int expressionOperandsLength = 0;

        for (PomidorToken expressionToken : expressionTokens) {

            if (expressionToken.getType().getClass() == operandType.getClass()) {

                expressionOperandsLength++;
            }
        }

        final String[] sourceCodeOperands = new String[expressionOperandsLength];

        for (int i = 0; i < expressionOperandsLength; i++) {

            sourceCodeOperands[i] = expressionTokens.get(i * 2).getSourceCode();
            sourceCodeOperands[i] = Objects.requireNonNullElse(variablesDatabase.getVariable(sourceCodeOperands[i]),
                                                               sourceCodeOperands[i]);
        }

        return sourceCodeOperands;
    }

    abstract T[] getExpressionOperands(List<PomidorToken> expressionTokens);
    abstract T calculateExpression(List<PomidorToken> expressionTokens, T[] expressionOperands);
}