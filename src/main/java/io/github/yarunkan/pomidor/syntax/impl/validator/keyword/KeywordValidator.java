package io.github.yarunkan.pomidor.syntax.impl.validator.keyword;

import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class KeywordValidator implements TokenValidator {

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