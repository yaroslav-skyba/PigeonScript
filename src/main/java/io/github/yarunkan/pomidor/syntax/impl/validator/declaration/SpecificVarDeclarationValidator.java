package io.github.yarunkan.pomidor.syntax.impl.validator.declaration;

import io.github.yarunkan.pomidor.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;

public abstract class SpecificVarDeclarationValidator<T> implements TokenValidator {

    private final TokenValidator varKeywordValidator;
    private final TokenValidator varNameValidator;
    private final TokenValidator assigmentOperatorValidator;
    private final SpecificExpressionValidator<T> expressionValidator;

    public SpecificVarDeclarationValidator(TokenValidator varKeywordValidator,
                                           TokenValidator varNameValidator,
                                           TokenValidator assigmentOperatorValidator,
                                           SpecificExpressionValidator<T> expressionValidator) {

        this.varKeywordValidator = varKeywordValidator;
        this.varNameValidator = varNameValidator;
        this.assigmentOperatorValidator = assigmentOperatorValidator;
        this.expressionValidator = expressionValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        if (!varKeywordValidator.validate(sourceCodeTokens[0])) {

            return false;
        }

        if (!varNameValidator.validate(sourceCodeTokens[1])) {

            return false;
        }

        if (!assigmentOperatorValidator.validate(sourceCodeTokens[2])) {

            return false;
        }

        final int notExpressionTokensCount = 3;
        final int expressionTokensCount = sourceCodeTokens.length - notExpressionTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, notExpressionTokensCount, expressionTokens, 0, expressionTokensCount);

        return expressionValidator.validate(expressionTokens);
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 == 0;
    }

    @Override
    public int getExpectedTokensCount() {

        return 4;
    }
}