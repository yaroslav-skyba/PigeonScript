package io.github.yarunkan.pomidor.syntax.impl.validator.operator;

import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import java.util.Set;

public interface SpecificOperatorValidator extends TokenValidator {

    Set<String> getOperatorSymbols();

    default boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return getOperatorSymbols().contains(sourceCodeTokens[0]);
    }
}