package io.github.yarunkan.pomidor.syntax.impl.validator.operator;

import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import java.util.Set;

public interface SpecificOperatorValidator<T> extends TokenValidator {

    Set<String> getOperatorSymbols();
    Class<T> getRelatedType();

    default boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return getOperatorSymbols().contains(sourceCodeTokens[0]);
    }
}