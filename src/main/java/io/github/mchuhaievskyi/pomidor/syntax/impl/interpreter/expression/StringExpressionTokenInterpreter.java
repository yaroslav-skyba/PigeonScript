package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StringExpressionTokenInterpreter extends SpecificExpressionTokenInterpreter<String> {

    private static final String QUOTE = "\"";
    private static final CharSequence EMPTY = "";

    @Autowired
    protected StringExpressionTokenInterpreter(PomidorTokenType operandType) {

        super(operandType);
    }

    @Override
    public String[] getExpressionOperands(List<PomidorToken> expressionTokens) {

        return getSourceCodeOperands(expressionTokens);
    }

    @Override
    public String calculateExpression(List<PomidorToken> expressionTokens, String[] expressionOperands) {

        if (expressionOperands.length == 1) {

            return QUOTE + expressionOperands[0] + QUOTE;
        }

        final String result = QUOTE + String.join(EMPTY, expressionOperands);

        return result + QUOTE;
    }
}