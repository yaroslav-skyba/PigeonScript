package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntOperandValidator implements SpecificOperandValidator<Integer> {

    private final PomidorTokenValidator intLiteralValidator;

    @Autowired
    public IntOperandValidator(PomidorTokenValidator intLiteralValidator) {

        this.intLiteralValidator = intLiteralValidator;
    }

    @Override
    public Class<Integer> getType() {

        return Integer.class;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        PomidorVariablesDatabase variablesDatabase = PomidorVariablesDatabaseImpl.getInstance();
        String operand = variablesDatabase.getVariable(sourceCodeTokens[0]);

        boolean b = intLiteralValidator.validate(sourceCodeTokens);
        boolean a = operand != null && intLiteralValidator.validate(operand);
        return b || a;
    }
}