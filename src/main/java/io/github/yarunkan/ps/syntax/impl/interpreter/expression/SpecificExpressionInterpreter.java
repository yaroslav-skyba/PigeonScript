package io.github.yarunkan.ps.syntax.impl.interpreter.expression;

import io.github.yarunkan.ps.database.variables.VariablesDatabase;
import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Objects;

public abstract class SpecificExpressionInterpreter<T> extends AbstractTokenInterpreter {

    private final VariablesDatabase variablesDatabase;
    private final TokenType operandType;
    private final TokenType operatorType;

    private T expressionResult;

    @Autowired
    protected SpecificExpressionInterpreter(VariablesDatabase variablesDatabase, TokenType operandType, TokenType operatorType) {

        this.variablesDatabase = variablesDatabase;
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

        int operandsCount = 0;

        for (Token expressionToken : expressionTokens) {

            if (expressionToken.getType().getClass() == operandType.getClass()) {

                operandsCount++;
            }
        }

        final String[] sourceCodeOperands = new String[operandsCount];

        for (int i = 0; i < operandsCount; i++) {

            sourceCodeOperands[i] = expressionTokens.get(i * 2).getSourceCode();
            sourceCodeOperands[i] = Objects.requireNonNullElse(variablesDatabase.get(sourceCodeOperands[i]), sourceCodeOperands[i]);
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