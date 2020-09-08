package io.github.yarunkan.ps.syntax.impl.validator.literal;

import io.github.yarunkan.ps.syntax.token.TokenValidator;

public interface SpecificLiteralValidator extends TokenValidator {

    Class<?> getType();
}