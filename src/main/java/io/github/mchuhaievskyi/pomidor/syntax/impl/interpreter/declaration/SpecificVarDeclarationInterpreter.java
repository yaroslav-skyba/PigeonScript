package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.declaration;

import io.github.mchuhaievskyi.pomidor.database.VariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.VariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.impl.TokenImpl;
import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenInterpreter;
import java.util.List;

public abstract class SpecificVarDeclarationInterpreter<T> extends TokenInterpreter {

    final VariablesDatabase variablesDatabase = VariablesDatabaseImpl.getInstance();

    private final SpecificExpressionInterpreter<T> specificExpressionTokenInterpreter;

    public SpecificVarDeclarationInterpreter(SpecificExpressionInterpreter<T> specificExpressionTokenInterpreter) {

        this.specificExpressionTokenInterpreter = specificExpressionTokenInterpreter;
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
        final String[] expressionSourceCode = new String[expressionTokens.size()];

        for (int i = 0; i < expressionSourceCode.length; i++) {

            expressionSourceCode[i] = expressionTokens.get(i).getSourceCode();
        }

        final String expressionSourceCodeLine = String.join(" ", expressionSourceCode);
        final Token expressionToken = new TokenImpl(token.getType(), expressionSourceCodeLine, expressionTokens);

        if (!specificExpressionTokenInterpreter.interpret(expressionToken)) {

            return false;
        }

        try {

            assignableVarValue = specificExpressionTokenInterpreter.getExpressionResult(expressionToken).toString();

        } catch (Exception e) {

            return false;
        }

        variablesDatabase.setVariable(assignableVarName, assignableVarValue);

        return true;
    }
}