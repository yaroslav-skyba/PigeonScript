package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.expression;

import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand.SpecificOperandValidator;
import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operator.SpecificOperatorValidator;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;

public abstract class SpecificExpressionValidator<T> implements TokenValidator {

    private final SpecificOperandValidator<T> operandValidator;
    private final SpecificOperatorValidator<T> operatorValidator;

    public SpecificExpressionValidator(SpecificOperandValidator<T> operandValidator, SpecificOperatorValidator<T> operatorValidator) {

        this.operandValidator = operandValidator;
        this.operatorValidator = operatorValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        boolean result = operandValidator.validate(sourceCodeTokens[0]);

        for (int i = 1; i < sourceCodeTokens.length; i += 2) {

            result &= operatorValidator.validate(sourceCodeTokens[i]) & operandValidator.validate(sourceCodeTokens[i + 1]);
        }

        return result;
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 != 0;
    }
}