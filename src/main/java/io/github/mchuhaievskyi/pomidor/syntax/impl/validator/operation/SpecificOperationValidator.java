package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operation;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class SpecificOperationValidator<T> implements PomidorTokenValidator {

    private final PomidorTokenValidator operandValidator;
    private final PomidorTokenValidator assigmentOperatorValidator;
    private final PomidorTokenValidator expressionValidator;

    @Autowired
    public SpecificOperationValidator(PomidorTokenValidator operandValidator,
                                      PomidorTokenValidator assigmentOperatorValidator,
                                      PomidorTokenValidator expressionValidator) {

        this.operandValidator = operandValidator;
        this.assigmentOperatorValidator = assigmentOperatorValidator;
        this.expressionValidator = expressionValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        if (!operandValidator.validate(sourceCodeTokens[0])) {

            return false;
        }

        if (!assigmentOperatorValidator.validate(sourceCodeTokens[1])) {

            return false;
        }

        final int sourceCodeTokensCount = sourceCodeTokens.length;
        final int previousTokensCount = 2;
        final int expressionTokensCount = sourceCodeTokensCount - previousTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, 2, expressionTokens, 0, expressionTokensCount);

        return expressionValidator.validate(expressionTokens);
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 != 0;
    }

    @Override
    public int getExpectedTokensCount() {

        return 3;
    }

    public abstract Class<T> getType();
}