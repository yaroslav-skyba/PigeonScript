package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.database.VariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.VariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringOperandValidator implements SpecificOperandValidator<String> {

    private final TokenValidator stringLiteralValidator;

    @Autowired
    public StringOperandValidator(TokenValidator stringLiteralValidator) {

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

        VariablesDatabase variablesDatabase = VariablesDatabaseImpl.getInstance();
        String operand = variablesDatabase.getVariable(sourceCodeTokens[0]);

        return  stringLiteralValidator.validate(sourceCodeTokens) ||
                (operand != null && stringLiteralValidator.validate(operand));
    }
}