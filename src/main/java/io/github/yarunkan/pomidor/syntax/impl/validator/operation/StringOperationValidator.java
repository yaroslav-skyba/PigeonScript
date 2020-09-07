package io.github.yarunkan.pomidor.syntax.impl.validator.operation;

import io.github.yarunkan.pomidor.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.pomidor.syntax.impl.validator.operand.SpecificOperandValidator;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringOperationValidator extends SpecificOperationValidator {

    @Autowired
    public StringOperationValidator(SpecificOperandValidator stringOperandValidator,
                                    TokenValidator assigmentOperatorValidator,
                                    SpecificExpressionValidator stringExpressionValidator) {

        super(stringOperandValidator, assigmentOperatorValidator, stringExpressionValidator);
    }
}