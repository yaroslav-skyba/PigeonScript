package io.github.yarunkan.ps.syntax.impl.interpreter.operation;

import io.github.yarunkan.ps.database.variables.VariablesDatabase;
import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.impl.PSTokenParserImpl;
import io.github.yarunkan.ps.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.ps.syntax.token.TokenType;
import java.util.List;

public abstract class SpecificOperationInterpreter extends AbstractTokenInterpreter {

    private final VariablesDatabase variablesDatabase;
    private final SpecificExpressionInterpreter<?> specificExpressionTokenInterpreter;
    private final TokenType expressionType;

    protected SpecificOperationInterpreter(VariablesDatabase variablesDatabase,
                                           SpecificExpressionInterpreter<?> specificExpressionTokenInterpreter,
                                           TokenType expressionType) {

        this.variablesDatabase = variablesDatabase;
        this.specificExpressionTokenInterpreter = specificExpressionTokenInterpreter;
        this.expressionType = expressionType;
    }

    @Override
    public boolean interpret(Token token) {

        final List<Token> subTokens = token.getSubTokens();
        final String assignableVarName = subTokens.get(0).getSourceCode();
        String assignableVarValue = variablesDatabase.get(assignableVarName);

        if (assignableVarValue == null) {

            return false;
        }

        final List<Token> expressionTokens = subTokens.subList(2, subTokens.size());
        final String[] expressionSourceCode = new String[expressionTokens.size()];

        for (int i = 0; i < expressionSourceCode.length; i++) {

            expressionSourceCode[i] = expressionTokens.get(i).getSourceCode();
        }

        final String expressionSourceCodeLine = String.join(" ", expressionSourceCode);
        final Token expressionToken = new PSTokenParserImpl(expressionSourceCodeLine, expressionType).takeNextToken();

        if (!specificExpressionTokenInterpreter.interpret(expressionToken)) {

            return false;
        }

        try {

            assignableVarValue = specificExpressionTokenInterpreter.getExpressionResult(expressionToken).toString();

        } catch (Exception e) {

            return false;
        }

        variablesDatabase.add(assignableVarName, assignableVarValue);

        return true;
    }
}