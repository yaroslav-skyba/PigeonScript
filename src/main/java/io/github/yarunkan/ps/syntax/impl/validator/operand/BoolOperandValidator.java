package io.github.yarunkan.ps.syntax.impl.validator.operand;

import io.github.yarunkan.ps.database.variables.VariablesDatabase;
import io.github.yarunkan.ps.syntax.impl.validator.literal.SpecificLiteralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolOperandValidator extends SpecificOperandValidator {

    @Autowired
    public BoolOperandValidator(SpecificLiteralValidator boolLiteralValidator, VariablesDatabase variablesDatabase) {

        super(variablesDatabase, boolLiteralValidator);
    }
}