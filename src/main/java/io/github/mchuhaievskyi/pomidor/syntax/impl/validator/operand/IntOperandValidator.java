package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.literal.SpecificLiteralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntOperandValidator extends SpecificOperandValidator<Long> {

    @Autowired
    public IntOperandValidator(SpecificLiteralValidator<Long> intLiteralValidator) {

        super(intLiteralValidator);
    }
}