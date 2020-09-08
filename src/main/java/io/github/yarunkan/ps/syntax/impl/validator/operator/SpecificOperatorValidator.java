package io.github.yarunkan.ps.syntax.impl.validator.operator;

import io.github.yarunkan.ps.syntax.token.TokenValidator;
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