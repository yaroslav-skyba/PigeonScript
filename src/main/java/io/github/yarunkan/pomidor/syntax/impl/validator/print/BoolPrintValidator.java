package io.github.yarunkan.pomidor.syntax.impl.validator.print;

import io.github.yarunkan.pomidor.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolPrintValidator extends SpecificPrintValidator {

    @Autowired
    public BoolPrintValidator(TokenValidator printKeywordValidator, SpecificExpressionValidator boolExpressionValidator) {

        super(printKeywordValidator, boolExpressionValidator);
    }
}