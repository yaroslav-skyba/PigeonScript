package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.expression;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class ExpressionValidator implements PomidorTokenValidator {

    private final Set<SpecificExpressionValidator> specificExpressionValidators;

    @Autowired
    public ExpressionValidator(Set<SpecificExpressionValidator> specificExpressionValidators) {

        this.specificExpressionValidators = specificExpressionValidators;
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 != 0;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return specificExpressionValidators.stream().anyMatch(v -> v.validate(sourceCodeTokens));
    }
}