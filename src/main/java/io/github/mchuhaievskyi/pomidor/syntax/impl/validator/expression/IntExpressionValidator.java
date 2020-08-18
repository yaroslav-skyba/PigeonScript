package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.expression;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntExpressionValidator implements SpecificExpressionValidator<Integer> {

    private final PomidorTokenValidator intOperandValidator;
    private final PomidorTokenValidator intOperatorValidator;

    @Autowired
    public IntExpressionValidator(PomidorTokenValidator intOperandValidator,
                                   PomidorTokenValidator intOperatorValidator) {

        this.intOperandValidator = intOperandValidator;
        this.intOperatorValidator = intOperatorValidator;
    }

    @Override
    public Class<Integer> getType() {

        return Integer.class;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        final int sourceCodeTokensLength = sourceCodeTokens.length;
        boolean result = intOperandValidator.validate(sourceCodeTokens[0]);

        if (sourceCodeTokensLength == 3) {

            result &= intOperatorValidator.validate(sourceCodeTokens[1]) & intOperandValidator.validate(sourceCodeTokens[2]);

        } else if (sourceCodeTokensLength > 3) {

            final int previousExpressionTokensCount = 2;
            final String[] expressionSourceCodeTokens = new String[sourceCodeTokensLength - previousExpressionTokensCount];

            System.arraycopy(sourceCodeTokens,
                    previousExpressionTokensCount,
                    expressionSourceCodeTokens, 0, sourceCodeTokensLength - previousExpressionTokensCount);

            final PomidorTokenValidator intExpressionValidator = new IntExpressionValidator(intOperandValidator, intOperatorValidator);

            result &= intOperatorValidator.validate(sourceCodeTokens[1]) & intExpressionValidator.validate(expressionSourceCodeTokens);
        }

        return result;
    }
}