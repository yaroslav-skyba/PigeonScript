package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.keyword;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;

public interface SpecificKeywordValidator extends TokenValidator {

    String getKeywordConstant();

    default boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return getKeywordConstant().equals(sourceCodeTokens[0]);
    }
}