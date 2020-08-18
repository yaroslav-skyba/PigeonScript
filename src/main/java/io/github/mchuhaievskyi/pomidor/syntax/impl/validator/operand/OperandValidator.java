package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operand;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class OperandValidator implements PomidorTokenValidator {

    private final Set<SpecificOperandValidator> specificOperandValidators;

    @Autowired
    public OperandValidator(Set<SpecificOperandValidator> specificOperandValidators) {

        this.specificOperandValidators = specificOperandValidators;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return specificOperandValidators.stream().anyMatch(v -> v.validate(sourceCodeTokens));
    }
}