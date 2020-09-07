package io.github.yarunkan.pomidor.syntax.impl.validator.literal;

import org.springframework.stereotype.Component;

@Component
public class BoolLiteralValidator implements SpecificLiteralValidator {

    @Override
    public Class<Boolean> getType() {

        return Boolean.class;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return "true".equals(sourceCodeTokens[0]) || "false".equals(sourceCodeTokens[0]);
    }
}