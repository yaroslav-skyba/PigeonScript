package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.keyword;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class KeywordValidator implements PomidorTokenValidator {

    private final Set<SpecificKeywordValidator> specificKeywordValidators;

    @Autowired
    public KeywordValidator(Set<SpecificKeywordValidator> specificKeywordValidators) {

        this.specificKeywordValidators = specificKeywordValidators;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return specificKeywordValidators.stream().anyMatch(v -> v.validate(sourceCodeTokens));
    }
}