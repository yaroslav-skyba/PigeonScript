package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.print;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorParser;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.impl.PomidorParserImpl;
import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression.SpecificExpressionTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import java.util.List;

public abstract class SpecificPrintCommandTokenInterpreter<T> extends PomidorTokenInterpreter {

    private final SpecificExpressionTokenInterpreter<T> specificExpressionTokenInterpreter;

    public SpecificPrintCommandTokenInterpreter(SpecificExpressionTokenInterpreter<T> specificExpressionTokenInterpreter) {

        this.specificExpressionTokenInterpreter = specificExpressionTokenInterpreter;
    }

    @Override
    public boolean interpret(PomidorToken token) {

        final List<PomidorToken> subTokens = token.getSubTokens();
        final List<PomidorToken> expressionTokens = subTokens.subList(1, subTokens.size());
        final String[] expressionSourceCodeLines = new String[expressionTokens.size()];

        for (int i = 0; i < expressionSourceCodeLines.length; i++) {

            expressionSourceCodeLines[i] = expressionTokens.get(i).getSourceCode();
        }

        final String expressionSourceCodeLine = String.join(" ", expressionSourceCodeLines);
        final PomidorParser expressionParser = new PomidorParserImpl(expressionSourceCodeLine, token.getType());
        final PomidorToken expressionToken = expressionParser.takeNextToken();

        if (!specificExpressionTokenInterpreter.interpret(expressionToken)) {

            return false;
        }

        printInterpretationResult(specificExpressionTokenInterpreter.getExpressionResult(expressionToken));

        return true;
    }

    void printInterpretationResult(T result) {

        System.out.println(result);
    }
}