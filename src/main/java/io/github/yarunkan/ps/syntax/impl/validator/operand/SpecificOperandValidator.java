package io.github.yarunkan.ps.syntax.impl.validator.operand;

import io.github.yarunkan.ps.database.variables.VariablesDatabase;
import io.github.yarunkan.ps.syntax.impl.validator.literal.SpecificLiteralValidator;
import io.github.yarunkan.ps.syntax.token.TokenValidator;

public abstract class SpecificOperandValidator implements TokenValidator {

    private final VariablesDatabase variablesDatabase;
    private final SpecificLiteralValidator literalValidator;

    protected SpecificOperandValidator(VariablesDatabase variablesDatabase, SpecificLiteralValidator literalValidator) {

        this.variablesDatabase = variablesDatabase;
        this.literalValidator = literalValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        final String operand = variablesDatabase.get(sourceCodeTokens[0]);

        return  operand != null && literalValidator.validate(operand) ||
                literalValidator.validate(sourceCodeTokens);
    }
}