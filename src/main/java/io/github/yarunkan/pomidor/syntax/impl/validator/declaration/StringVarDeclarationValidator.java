package io.github.yarunkan.pomidor.syntax.impl.validator.declaration;

import io.github.yarunkan.pomidor.syntax.impl.validator.expression.SpecificExpressionValidator;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringVarDeclarationValidator extends SpecificVarDeclarationValidator<String> {

    @Autowired
    public StringVarDeclarationValidator(TokenValidator varKeywordValidator,
                                         TokenValidator varNameValidator, TokenValidator assigmentOperatorValidator,
                                         SpecificExpressionValidator<String> stringExpressionValidator) {

        super(varKeywordValidator, varNameValidator, assigmentOperatorValidator, stringExpressionValidator);
    }
}