package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.literal;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class LiteralValidator implements TokenValidator {

    private final Set<SpecificLiteralValidator> specificLiteralValidators;

    @Autowired
    public LiteralValidator(Set<SpecificLiteralValidator> specificLiteralValidators) {

        this.specificLiteralValidators = specificLiteralValidators;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return specificLiteralValidators.stream().anyMatch(v -> v.validate(sourceCodeTokens));
    }
}