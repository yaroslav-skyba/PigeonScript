package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.literal;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;

public interface SpecificLiteralValidator<T> extends PomidorTokenValidator {

    Class<T> getType();
}