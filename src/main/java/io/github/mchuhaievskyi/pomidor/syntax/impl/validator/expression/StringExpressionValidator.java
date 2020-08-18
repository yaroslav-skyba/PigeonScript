package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.expression;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringExpressionValidator implements SpecificExpressionValidator<String> {

    private final PomidorTokenValidator stringOperandValidator;
    private final PomidorTokenValidator stringOperatorValidator;

    @Autowired
    public StringExpressionValidator(PomidorTokenValidator stringOperandValidator,
                                     PomidorTokenValidator stringOperatorValidator) {

        this.stringOperandValidator = stringOperandValidator;
        this.stringOperatorValidator = stringOperatorValidator;
    }

    @Override
    public Class<String> getType() {

        return String.class;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        final int sourceCodeTokensLength = sourceCodeTokens.length;
        boolean result = stringOperandValidator.validate(sourceCodeTokens[0]);

        if (sourceCodeTokensLength == 3) {

            result &= stringOperatorValidator.validate(sourceCodeTokens[1]) & stringOperandValidator.validate(sourceCodeTokens[2]);

        } else if (sourceCodeTokensLength > 3) {

            final int previousExpressionTokensCount = 2;
            final String[] expressionSourceCodeTokens = new String[sourceCodeTokensLength - previousExpressionTokensCount];

            System.arraycopy(sourceCodeTokens,
                    previousExpressionTokensCount,
                    expressionSourceCodeTokens, 0, sourceCodeTokensLength - previousExpressionTokensCount);

            result &= stringOperatorValidator.validate(sourceCodeTokens[1]) &
                      new StringExpressionValidator(stringOperandValidator, stringOperatorValidator).validate(expressionSourceCodeTokens);
        }

        return result;
    }
}