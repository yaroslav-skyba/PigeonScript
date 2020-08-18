package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringOperandValidator implements SpecificOperandValidator<String> {

    private final PomidorTokenValidator stringLiteralValidator;

    @Autowired
    public StringOperandValidator(PomidorTokenValidator stringLiteralValidator) {

        this.stringLiteralValidator = stringLiteralValidator;
    }

    @Override
    public Class<String> getType() {

        return String.class;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        PomidorVariablesDatabase variablesDatabase = PomidorVariablesDatabaseImpl.getInstance();
        String operand = variablesDatabase.getVariable(sourceCodeTokens[0]);

        return  stringLiteralValidator.validate(sourceCodeTokens) ||
                (operand != null && stringLiteralValidator.validate(operand));
    }
}