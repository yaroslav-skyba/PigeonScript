package io.github.yarunkan.ps.syntax.impl.validator.print;

import io.github.yarunkan.ps.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringPrintValidator extends SpecificPrintValidator {

    @Autowired
    public StringPrintValidator(TokenValidator printKeywordValidator,
                                SpecificExpressionValidator stringExpressionValidator) {

        super(printKeywordValidator, stringExpressionValidator);
    }
}