package io.github.yarunkan.ps.syntax.impl.validator.operation;

import io.github.yarunkan.ps.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.ps.syntax.impl.validator.operand.SpecificOperandValidator;
import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntOperationValidator extends SpecificOperationValidator {

    @Autowired
    public IntOperationValidator(SpecificOperandValidator intOperandValidator,
                                 TokenValidator assigmentOperatorValidator,
                                 SpecificExpressionValidator intExpressionValidator) {

        super(intOperandValidator, assigmentOperatorValidator, intExpressionValidator);
    }
}