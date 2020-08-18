package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.literal;

import org.springframework.stereotype.Component;

@Component
public class IntLiteralValidator implements SpecificLiteralValidator<Integer> {

    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return sourceCodeTokens[0] != null && sourceCodeTokens[0].matches("-?\\d{1,9}");
    }
}