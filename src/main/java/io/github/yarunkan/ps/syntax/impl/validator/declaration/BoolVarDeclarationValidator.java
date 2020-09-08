package io.github.yarunkan.ps.syntax.impl.validator.declaration;

import io.github.yarunkan.ps.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolVarDeclarationValidator extends SpecificVarDeclarationValidator {

    @Autowired
    public BoolVarDeclarationValidator(TokenValidator varKeywordValidator,
                                       TokenValidator varNameValidator, TokenValidator assigmentOperatorValidator,
                                       SpecificExpressionValidator boolExpressionValidator) {

        super(varKeywordValidator, varNameValidator, assigmentOperatorValidator, boolExpressionValidator);
    }
}