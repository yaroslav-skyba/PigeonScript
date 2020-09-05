package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.literal.SpecificLiteralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringOperandValidator extends SpecificOperandValidator<String> {

    @Autowired
    public StringOperandValidator(SpecificLiteralValidator<String> stringLiteralValidator) {

        super(stringLiteralValidator);
    }
}