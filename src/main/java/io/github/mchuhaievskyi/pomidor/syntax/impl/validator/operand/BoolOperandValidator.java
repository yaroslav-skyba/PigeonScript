package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.database.VariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.VariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolOperandValidator implements SpecificOperandValidator<Boolean> {

    private final TokenValidator boolLiteralValidator;

    @Autowired
    public BoolOperandValidator(TokenValidator boolLiteralValidator) {

        this.boolLiteralValidator = boolLiteralValidator;
    }

    @Override
    public Class<Boolean> getType() {

        return Boolean.class;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        VariablesDatabase variablesDatabase = VariablesDatabaseImpl.getInstance();
        String operand = variablesDatabase.getVariable(sourceCodeTokens[0]);

        return  boolLiteralValidator.validate(sourceCodeTokens) || (operand != null && boolLiteralValidator.validate(operand));
    }
}