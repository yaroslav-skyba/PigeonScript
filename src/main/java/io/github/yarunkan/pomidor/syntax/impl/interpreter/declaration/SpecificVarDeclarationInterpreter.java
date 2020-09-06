package io.github.yarunkan.pomidor.syntax.impl.interpreter.declaration;

import io.github.yarunkan.pomidor.database.variables.VariablesDatabase;
import io.github.yarunkan.pomidor.database.variables.VariablesDatabaseImpl;
import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.TokenImpl;
import io.github.yarunkan.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import java.util.List;

public abstract class SpecificVarDeclarationInterpreter<T> extends AbstractTokenInterpreter {

    final VariablesDatabase variablesDatabase = VariablesDatabaseImpl.getInstance();

    private final SpecificExpressionInterpreter<T> specificExpressionInterpreter;

    public SpecificVarDeclarationInterpreter(SpecificExpressionInterpreter<T> specificExpressionInterpreter) {

        this.specificExpressionInterpreter = specificExpressionInterpreter;
    }

    @Override
    public boolean interpret(Token token) {

        final List<Token> subTokens = token.getSubTokens();
        final String assignableVarName = subTokens.get(1).getSourceCode();

        String assignableVarValue = variablesDatabase.getVariable(assignableVarName);

        if (assignableVarValue != null) {

            return false;
        }

        final List<Token> expressionTokens = subTokens.subList(3, subTokens.size());
        final String[] expressionSourceCodeLines = new String[expressionTokens.size()];

        for (int i = 0; i < expressionSourceCodeLines.length; i++) {

            expressionSourceCodeLines[i] = expressionTokens.get(i).getSourceCode();
        }

        final Token expressionToken = new TokenImpl(token.getType(), String.join(" ", expressionSourceCodeLines), expressionTokens);

        if (!specificExpressionInterpreter.interpret(expressionToken)) {

            return false;
        }

        try {

            assignableVarValue = specificExpressionInterpreter.getExpressionResult(expressionToken).toString();

        } catch (Exception e) {

            return false;
        }

        variablesDatabase.setVariable(assignableVarName, assignableVarValue);

        return true;
    }
}