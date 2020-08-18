package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolOperandValidator implements SpecificOperandValidator<Boolean> {

    private final PomidorTokenValidator boolLiteralValidator;

    @Autowired
    public BoolOperandValidator(PomidorTokenValidator boolLiteralValidator) {

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

        PomidorVariablesDatabase variablesDatabase = PomidorVariablesDatabaseImpl.getInstance();
        String operand = variablesDatabase.getVariable(sourceCodeTokens[0]);

        return  boolLiteralValidator.validate(sourceCodeTokens) || (operand != null && boolLiteralValidator.validate(operand));
    }
}