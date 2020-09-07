package io.github.yarunkan.pomidor.syntax.impl.validator.expression;

import io.github.yarunkan.pomidor.syntax.impl.validator.operand.SpecificOperandValidator;
import io.github.yarunkan.pomidor.syntax.impl.validator.operator.SpecificOperatorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntExpressionValidator extends SpecificExpressionValidator {

    @Autowired
    public IntExpressionValidator(SpecificOperandValidator intOperandValidator, SpecificOperatorValidator intOperatorValidator) {

        super(intOperandValidator, intOperatorValidator);
    }
}