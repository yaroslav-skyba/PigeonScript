package io.github.yarunkan.pomidor.syntax.impl.validator.literal;

import org.springframework.stereotype.Component;

@Component
public class StringLiteralValidator implements SpecificLiteralValidator {

    @Override
    public Class<String> getType() {
        return String.class;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return sourceCodeTokens[0] != null && sourceCodeTokens[0].matches("\"[^\"]*\"");
    }
}