package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operation;

import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand.SpecificOperandValidator;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntOperationValidator extends SpecificOperationValidator<Long> {

    @Autowired
    public IntOperationValidator(SpecificOperandValidator<Long> intOperandValidator,
                                 TokenValidator assigmentOperatorValidator,
                                 SpecificExpressionValidator<Long> intExpressionValidator) {

        super(intOperandValidator, assigmentOperatorValidator, intExpressionValidator);
    }
}