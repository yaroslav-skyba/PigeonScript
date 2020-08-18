package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operation;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringOperationValidator extends SpecificOperationValidator<String> {

    @Autowired
    public StringOperationValidator(PomidorTokenValidator stringOperandValidator,
                                    PomidorTokenValidator assigmentOperatorValidator,
                                    PomidorTokenValidator stringExpressionValidator) {

        super(stringOperandValidator, assigmentOperatorValidator, stringExpressionValidator);
    }

    @Override
    public Class<String> getType() {

        return String.class;
    }
}