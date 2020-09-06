package io.github.yarunkan.pomidor.syntax.impl.validator.declaration;

import io.github.yarunkan.pomidor.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntVarDeclarationValidator extends SpecificVarDeclarationValidator<Long> {

    @Autowired
    public IntVarDeclarationValidator(TokenValidator varKeywordValidator, TokenValidator varNameValidator,
                                      TokenValidator assigmentOperatorValidator,
                                      SpecificExpressionValidator<Long> intExpressionValidator) {

        super(varKeywordValidator, varNameValidator, assigmentOperatorValidator, intExpressionValidator);
    }
}