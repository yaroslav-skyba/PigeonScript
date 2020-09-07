package io.github.yarunkan.pomidor.syntax.impl.validator.operand;

import io.github.yarunkan.pomidor.database.variables.VariablesDatabase;
import io.github.yarunkan.pomidor.syntax.impl.validator.literal.SpecificLiteralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringOperandValidator extends SpecificOperandValidator {

    @Autowired
    public StringOperandValidator(SpecificLiteralValidator stringLiteralValidator, VariablesDatabase variablesDatabase) {

        super(variablesDatabase, stringLiteralValidator);
    }
}