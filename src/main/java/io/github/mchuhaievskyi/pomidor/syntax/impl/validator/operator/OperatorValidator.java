package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operator;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class OperatorValidator implements PomidorTokenValidator {

    private final Set<SpecificOperatorValidator> specificOperatorValidators;

    @Autowired
    public OperatorValidator(Set<SpecificOperatorValidator> specificOperatorValidators) {

        this.specificOperatorValidators = specificOperatorValidators;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return specificOperatorValidators.stream().anyMatch(v -> v.validate(sourceCodeTokens));
    }
}