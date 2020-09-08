package io.github.yarunkan.ps.syntax.impl.validator.keyword;

import io.github.yarunkan.ps.syntax.token.TokenValidator;

public interface SpecificKeywordValidator extends TokenValidator {

    String getKeywordConstant();

    default boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return getKeywordConstant().equals(sourceCodeTokens[0]);
    }
}