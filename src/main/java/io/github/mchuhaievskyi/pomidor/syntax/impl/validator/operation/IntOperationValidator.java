package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operation;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntOperationValidator extends SpecificOperationValidator<Integer> {

    @Autowired
    public IntOperationValidator(PomidorTokenValidator intOperandValidator,
                                 PomidorTokenValidator assigmentOperatorValidator,
                                 PomidorTokenValidator intExpressionValidator) {

        super(intOperandValidator, assigmentOperatorValidator, intExpressionValidator);
    }

    @Override
    public Class<Integer> getType() {

        return Integer.class;
    }
}