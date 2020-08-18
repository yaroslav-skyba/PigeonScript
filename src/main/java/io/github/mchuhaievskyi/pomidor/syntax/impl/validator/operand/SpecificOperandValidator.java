package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;

public interface SpecificOperandValidator<T> extends PomidorTokenValidator {

    Class<T> getType();
}