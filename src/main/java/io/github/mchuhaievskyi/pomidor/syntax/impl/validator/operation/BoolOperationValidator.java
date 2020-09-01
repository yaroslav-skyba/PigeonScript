package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operation;

import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand.SpecificOperandValidator;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolOperationValidator extends SpecificOperationValidator<Boolean> {

    @Autowired
    public BoolOperationValidator(SpecificOperandValidator<Boolean> boolOperandValidator,
                                  TokenValidator assigmentOperatorValidator,
                                  SpecificExpressionValidator<Boolean> boolExpressionValidator) {

        super(boolOperandValidator, assigmentOperatorValidator, boolExpressionValidator);
    }
}