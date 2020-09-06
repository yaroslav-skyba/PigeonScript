package io.github.yarunkan.pomidor.syntax.impl.validator.keyword;

import io.github.yarunkan.pomidor.syntax.token.TokenValidator;

public interface SpecificKeywordValidator extends TokenValidator {

    String getKeywordConstant();

    default boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return getKeywordConstant().equals(sourceCodeTokens[0]);
    }
}