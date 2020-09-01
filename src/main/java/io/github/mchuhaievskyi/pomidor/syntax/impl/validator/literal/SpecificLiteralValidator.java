package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.literal;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;

public interface SpecificLiteralValidator<T> extends TokenValidator {

    Class<T> getType();
}