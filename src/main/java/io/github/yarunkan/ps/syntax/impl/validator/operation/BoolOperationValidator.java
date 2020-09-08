package io.github.yarunkan.ps.syntax.impl.validator.operation;

import io.github.yarunkan.ps.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.ps.syntax.impl.validator.operand.SpecificOperandValidator;
import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolOperationValidator extends SpecificOperationValidator {

    @Autowired
    public BoolOperationValidator(SpecificOperandValidator boolOperandValidator,
                                  TokenValidator assigmentOperatorValidator,
                                  SpecificExpressionValidator boolExpressionValidator) {

        super(boolOperandValidator, assigmentOperatorValidator, boolExpressionValidator);
    }
}