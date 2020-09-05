package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression;

import io.github.mchuhaievskyi.pomidor.database.variables.VariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.variables.VariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Objects;

public abstract class SpecificExpressionInterpreter<T> extends AbstractTokenInterpreter {

    final VariablesDatabase variablesDatabase = VariablesDatabaseImpl.getInstance();

    private final TokenType operandType;
    private final TokenType operatorType;
    private T expressionResult;

    @Autowired
    protected SpecificExpressionInterpreter(TokenType operandType, TokenType operatorType) {

        this.operandType = operandType;
        this.operatorType = operatorType;
    }

    @Override
    public boolean interpret(Token token) {

        try {

            final List<Token> subTokens = token.getSubTokens();

            expressionResult = calculateExpression(getExpressionOperators(subTokens), getExpressionOperands(subTokens));

        } catch (RuntimeException e) {

            return false;
        }

        return true;
    }

    public T getExpressionResult(Token token) {

        if (!interpret(token)) {

            throw new IllegalStateException("Can not interpret an expression");
        }

        return expressionResult;
    }

    String[] getSourceCodeOperands(List<Token> expressionTokens) {

        int expressionOperandsLength = 0;

        for (Token expressionToken : expressionTokens) {

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

    String[] getExpressionOperators(List<Token> expressionTokens) {

        int operatorsCount = 0;

        for (Token expressionToken : expressionTokens) {

            if (expressionToken.getType().getClass() == operatorType.getClass()) {

                operatorsCount++;
            }
        }

        final String[] operators = new String[operatorsCount];

        for (int i = 0; i < operatorsCount; i++) {

            operators[i] = expressionTokens.get(i * 2 + 1).getSourceCode();
        }

        return operators;
    }

    abstract T[] getExpressionOperands(List<Token> expressionTokens);
    abstract T calculateExpression(String[] expressionOperators, T[] expressionOperands);
}