package io.github.yarunkan.pomidor.syntax.impl.validator.print;

import io.github.yarunkan.pomidor.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;

public abstract class SpecificPrintCommandValidator<T> implements TokenValidator {

    private final TokenValidator printKeywordValidator;
    private final SpecificExpressionValidator<T> expressionValidator;

    public SpecificPrintCommandValidator(TokenValidator printKeywordValidator, SpecificExpressionValidator<T> expressionValidator) {

        this.printKeywordValidator = printKeywordValidator;
        this.expressionValidator = expressionValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        if (!printKeywordValidator.validate(sourceCodeTokens[0])) {

            return false;
        }

        final int notExpressionTokensCount = 1;
        final int expressionTokensCount = sourceCodeTokens.length - notExpressionTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, 1, expressionTokens, 0, expressionTokensCount);

        return expressionValidator.validate(expressionTokens);
    }

    @Override
    public int getExpectedTokensCount() {

        return 2;
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 == 0;
    }
}