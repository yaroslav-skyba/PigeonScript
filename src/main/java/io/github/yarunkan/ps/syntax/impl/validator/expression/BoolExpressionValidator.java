package io.github.yarunkan.ps.syntax.impl.validator.expression;

import io.github.yarunkan.ps.syntax.impl.validator.operand.SpecificOperandValidator;
import io.github.yarunkan.ps.syntax.impl.validator.operator.SpecificOperatorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolExpressionValidator extends SpecificExpressionValidator {

    @Autowired
    public BoolExpressionValidator(SpecificOperandValidator boolOperandValidator, SpecificOperatorValidator boolOperatorValidator) {

        super(boolOperandValidator, boolOperatorValidator);
    }
}