package io.github.yarunkan.pomidor.syntax.impl.validator.operand;

import io.github.yarunkan.pomidor.database.variables.VariablesDatabase;
import io.github.yarunkan.pomidor.database.variables.VariablesDatabaseImpl;
import io.github.yarunkan.pomidor.syntax.impl.validator.literal.SpecificLiteralValidator;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;

public abstract class SpecificOperandValidator<T> implements TokenValidator {

    final VariablesDatabase variablesDatabase = VariablesDatabaseImpl.getInstance();

    private final SpecificLiteralValidator<T> literalValidator;

    protected SpecificOperandValidator(SpecificLiteralValidator<T> literalValidator) {

        this.literalValidator = literalValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        final String operand = variablesDatabase.getVariable(sourceCodeTokens[0]);

        return operand != null && literalValidator.validate(operand) || literalValidator.validate(sourceCodeTokens);
    }
}