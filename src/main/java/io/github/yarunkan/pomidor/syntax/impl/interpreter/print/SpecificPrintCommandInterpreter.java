package io.github.yarunkan.pomidor.syntax.impl.interpreter.print;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.TokenImpl;
import io.github.yarunkan.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;

import java.util.List;

public abstract class SpecificPrintCommandInterpreter<T> extends AbstractTokenInterpreter {

    private final SpecificExpressionInterpreter<T> specificExpressionTokenInterpreter;

    public SpecificPrintCommandInterpreter(SpecificExpressionInterpreter<T> specificExpressionTokenInterpreter) {

        this.specificExpressionTokenInterpreter = specificExpressionTokenInterpreter;
    }

    @Override
    public boolean interpret(Token token) {

        final List<Token> subTokens = token.getSubTokens();
        final List<Token> expressionTokens = subTokens.subList(1, subTokens.size());
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

            printInterpretationResult(specificExpressionTokenInterpreter.getExpressionResult(expressionToken));

        } catch (Exception e) {

            return false;
        }

        return true;
    }

    void printInterpretationResult(T result) {

        System.out.println(result);
    }
}