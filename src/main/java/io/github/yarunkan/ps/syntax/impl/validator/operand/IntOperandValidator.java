package io.github.yarunkan.ps.syntax.impl.validator.operand;

import io.github.yarunkan.ps.database.variables.VariablesDatabase;
import io.github.yarunkan.ps.syntax.impl.validator.literal.SpecificLiteralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntOperandValidator extends SpecificOperandValidator {

    @Autowired
    public IntOperandValidator(SpecificLiteralValidator intLiteralValidator, VariablesDatabase variablesDatabase) {

        super(variablesDatabase, intLiteralValidator);
    }
}