package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operator;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import java.util.Set;

public interface SpecificOperatorValidator<T> extends PomidorTokenValidator {

    Class<T> getRelatedType();
    Set<String> getOperatorSymbols();

    default boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return getOperatorSymbols().contains(sourceCodeTokens[0]);
    }
}