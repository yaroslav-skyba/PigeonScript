package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operation;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolOperationValidator extends SpecificOperationValidator<Boolean> {

    @Autowired
    public BoolOperationValidator(PomidorTokenValidator boolOperandValidator,
                                  PomidorTokenValidator assigmentOperatorValidator,
                                  PomidorTokenValidator boolExpressionValidator) {

        super(boolOperandValidator, assigmentOperatorValidator, boolExpressionValidator);
    }

    @Override
    public Class<Boolean> getType() {

        return Boolean.class;
    }
}