package io.github.yarunkan.ps.syntax.impl.interpreter.print;

import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.impl.TokenImpl;
import io.github.yarunkan.ps.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import java.util.List;

public abstract class SpecificPrintCommandInterpreter<T> extends AbstractTokenInterpreter {

    private final SpecificExpressionInterpreter<T> expressionTokenInterpreter;

    public SpecificPrintCommandInterpreter(SpecificExpressionInterpreter<T> expressionTokenInterpreter) {

        this.expressionTokenInterpreter = expressionTokenInterpreter;
    }

    @Override
    public boolean interpret(Token token) {

        final List<Token> subTokens = token.getSubTokens();
        final List<Token> expressionTokens = subTokens.subList(1, subTokens.size());
        final String[] expressionSourceCodeTokens = new String[expressionTokens.size()];

        for (int i = 0; i < expressionSourceCodeTokens.length; i++) {

            expressionSourceCodeTokens[i] = expressionTokens.get(i).getSourceCode();
        }

        final Token expressionToken = new TokenImpl(token.getType(), String.join(" ", expressionSourceCodeTokens), expressionTokens);

        if (!expressionTokenInterpreter.interpret(expressionToken)) {

            return false;
        }

        try {

            printInterpretationResult(expressionTokenInterpreter.getExpressionResult(expressionToken));

        } catch (Exception e) {

            return false;
        }

        return true;
    }

    void printInterpretationResult(T result) {

        System.out.println(result);
    }
}