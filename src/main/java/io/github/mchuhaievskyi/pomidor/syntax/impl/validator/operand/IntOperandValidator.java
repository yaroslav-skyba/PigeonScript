package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.database.VariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.VariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntOperandValidator implements SpecificOperandValidator<Long> {

    private final TokenValidator intLiteralValidator;

    @Autowired
    public IntOperandValidator(TokenValidator intLiteralValidator) {

        this.intLiteralValidator = intLiteralValidator;
    }

    @Override
    public Class<Long> getType() {

        return Long.class;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        VariablesDatabase variablesDatabase = VariablesDatabaseImpl.getInstance();
        String operand = variablesDatabase.getVariable(sourceCodeTokens[0]);

        boolean b = intLiteralValidator.validate(sourceCodeTokens);
        boolean a = operand != null && intLiteralValidator.validate(operand);
        return b || a;
    }
}