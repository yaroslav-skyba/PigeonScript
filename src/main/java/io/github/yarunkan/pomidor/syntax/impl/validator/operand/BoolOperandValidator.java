package io.github.yarunkan.pomidor.syntax.impl.validator.operand;

import io.github.yarunkan.pomidor.syntax.impl.validator.literal.SpecificLiteralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolOperandValidator extends SpecificOperandValidator<Boolean> {

    @Autowired
    public BoolOperandValidator(SpecificLiteralValidator<Boolean> boolLiteralValidator) {

        super(boolLiteralValidator);
    }
}