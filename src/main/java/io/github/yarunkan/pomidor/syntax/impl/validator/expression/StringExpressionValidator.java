package io.github.yarunkan.pomidor.syntax.impl.validator.expression;

import io.github.yarunkan.pomidor.syntax.impl.validator.operand.SpecificOperandValidator;
import io.github.yarunkan.pomidor.syntax.impl.validator.operator.SpecificOperatorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringExpressionValidator extends SpecificExpressionValidator {

    @Autowired
    public StringExpressionValidator(SpecificOperandValidator stringOperandValidator, SpecificOperatorValidator stringOperatorValidator) {

        super(stringOperandValidator, stringOperatorValidator);
    }
}