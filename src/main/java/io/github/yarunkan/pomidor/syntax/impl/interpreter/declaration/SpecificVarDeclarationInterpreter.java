package io.github.yarunkan.pomidor.syntax.impl.interpreter.declaration;

import io.github.yarunkan.pomidor.database.variables.VariablesDatabase;
import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.TokenImpl;
import io.github.yarunkan.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import java.util.List;

public abstract class SpecificVarDeclarationInterpreter extends AbstractTokenInterpreter {

    private final VariablesDatabase variablesDatabase;
    private final SpecificExpressionInterpreter<?> expressionInterpreter;

    public SpecificVarDeclarationInterpreter(VariablesDatabase variablesDatabase, SpecificExpressionInterpreter<?> expressionInterpreter) {

        this.variablesDatabase = variablesDatabase;
        this.expressionInterpreter = expressionInterpreter;
    }

    @Override
    public boolean interpret(Token token) {

        final List<Token> subTokens = token.getSubTokens();
        final String assignableVarName = subTokens.get(1).getSourceCode();

        String assignableVarValue = variablesDatabase.get(assignableVarName);

        if (assignableVarValue != null) {

            return false;
        }

        final List<Token> expressionTokens = subTokens.subList(3, subTokens.size());
        final String[] expressionSourceCodeTokens = new String[expressionTokens.size()];

        for (int i = 0; i < expressionSourceCodeTokens.length; i++) {

            expressionSourceCodeTokens[i] = expressionTokens.get(i).getSourceCode();
        }

        final Token expressionToken = new TokenImpl(token.getType(), String.join(" ", expressionSourceCodeTokens), expressionTokens);

        if (!expressionInterpreter.interpret(expressionToken)) {

            return false;
        }

        try {

            assignableVarValue = expressionInterpreter.getExpressionResult(expressionToken).toString();

        } catch (Exception e) {

            return false;
        }

        variablesDatabase.add(assignableVarName, assignableVarValue);

        return true;
    }
}