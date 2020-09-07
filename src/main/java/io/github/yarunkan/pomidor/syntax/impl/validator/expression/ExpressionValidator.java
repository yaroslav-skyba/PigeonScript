package io.github.yarunkan.pomidor.syntax.impl.validator.expression;

import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class ExpressionValidator implements TokenValidator {

    private final Set<SpecificExpressionValidator> specificExpressionValidators;

    @Autowired
    public ExpressionValidator(Set<SpecificExpressionValidator> specificExpressionValidators) {

        this.specificExpressionValidators = specificExpressionValidators;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        return specificExpressionValidators.stream().anyMatch(v -> v.validate(sourceCodeTokens));
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 != 0;
    }
}