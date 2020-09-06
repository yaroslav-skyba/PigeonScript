package io.github.yarunkan.pomidor.syntax.impl.validator.literal;

import io.github.yarunkan.pomidor.syntax.token.TokenValidator;

public interface SpecificLiteralValidator<T> extends TokenValidator {

    Class<T> getType();
}