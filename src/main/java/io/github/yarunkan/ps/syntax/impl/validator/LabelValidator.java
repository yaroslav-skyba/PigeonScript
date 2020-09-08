package io.github.yarunkan.ps.syntax.impl.validator;

import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LabelValidator implements TokenValidator {

    private final TokenValidator labelKeywordValidator;
    private final TokenValidator varNameValidator;

    @Autowired
    public LabelValidator(TokenValidator labelKeywordValidator, TokenValidator varNameValidator) {

        this.labelKeywordValidator = labelKeywordValidator;
        this.varNameValidator = varNameValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        if (!labelKeywordValidator.validate(sourceCodeTokens[0])) {

            return false;
        }

        return varNameValidator.validate(sourceCodeTokens[1]);
    }

    @Override
    public int getExpectedTokensCount() {

        return 2;
    }
}