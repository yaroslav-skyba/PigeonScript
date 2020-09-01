package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;

public interface SpecificOperandValidator<T> extends TokenValidator {

    Class<T> getType();
}