package io.github.mchuhaievskyi.pomidor.syntax.impl.validator;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarDeclarationValidator implements TokenValidator {

    private final TokenValidator varKeywordValidator;
    private final TokenValidator varNameValidator;
    private final TokenValidator assigmentOperatorValidator;
    private final TokenValidator expressionValidator;

    @Autowired
    public VarDeclarationValidator(TokenValidator varKeywordValidator,
                                   TokenValidator varNameValidator,
                                   TokenValidator assigmentOperatorValidator,
                                   TokenValidator expressionValidator) {

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