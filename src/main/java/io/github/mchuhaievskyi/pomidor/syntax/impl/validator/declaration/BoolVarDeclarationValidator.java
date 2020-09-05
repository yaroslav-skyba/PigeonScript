package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.declaration;

import io.github.mchuhaievskyi.pomidor.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolVarDeclarationValidator extends SpecificVarDeclarationValidator<Boolean> {

    @Autowired
    public BoolVarDeclarationValidator(TokenValidator varKeywordValidator,
                                       TokenValidator varNameValidator, TokenValidator assigmentOperatorValidator,
                                       SpecificExpressionValidator<Boolean> boolExpressionValidator) {

        super(varKeywordValidator, varNameValidator, assigmentOperatorValidator, boolExpressionValidator);
    }
}