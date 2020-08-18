package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.expression;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolExpressionValidator implements SpecificExpressionValidator<Boolean> {

    private final PomidorTokenValidator boolOperandValidator;
    private final PomidorTokenValidator boolOperatorValidator;

    @Autowired
    public BoolExpressionValidator(PomidorTokenValidator boolOperandValidator,
                                   PomidorTokenValidator boolOperatorValidator) {

        this.boolOperandValidator = boolOperandValidator;
        this.boolOperatorValidator = boolOperatorValidator;
    }

    @Override
    public Class<Boolean> getType() {

        return Boolean.class;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        final int sourceCodeTokensLength = sourceCodeTokens.length;
        boolean result = boolOperandValidator.validate(sourceCodeTokens[0]);

        if (sourceCodeTokensLength == 3) {

            result &= boolOperatorValidator.validate(sourceCodeTokens[1]) & boolOperandValidator.validate(sourceCodeTokens[2]);

        } else if (sourceCodeTokensLength > 3) {

            final int previousExpressionTokensCount = 2;
            final String[] expressionSourceCodeTokens = new String[sourceCodeTokensLength - previousExpressionTokensCount];

            System.arraycopy(sourceCodeTokens,
                    previousExpressionTokensCount,
                    expressionSourceCodeTokens, 0, sourceCodeTokensLength - previousExpressionTokensCount);

            final PomidorTokenValidator boolExpressionValidator = new BoolExpressionValidator(boolOperandValidator, boolOperatorValidator);

            result &= boolOperatorValidator.validate(sourceCodeTokens[1]) & boolExpressionValidator.validate(expressionSourceCodeTokens);
        }

        return result;
    }
}