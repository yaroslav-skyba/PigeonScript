package io.github.yarunkan.pomidor.syntax.impl.validator.print;

import io.github.yarunkan.pomidor.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntPrintValidator extends SpecificPrintValidator {

    @Autowired
    public IntPrintValidator(TokenValidator printKeywordValidator, SpecificExpressionValidator intExpressionValidator) {

        super(printKeywordValidator, intExpressionValidator);
    }
}