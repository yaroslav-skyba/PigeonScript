package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.expression;

import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand.SpecificOperandValidator;
import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operator.SpecificOperatorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntExpressionValidator extends SpecificExpressionValidator<Long> {

    @Autowired
    public IntExpressionValidator(SpecificOperandValidator<Long> intOperandValidator,
                                  SpecificOperatorValidator<Long> intOperatorValidator) {

        super(intOperandValidator, intOperatorValidator);
    }
}