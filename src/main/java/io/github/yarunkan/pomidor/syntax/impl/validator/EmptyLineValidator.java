package io.github.yarunkan.pomidor.syntax.impl.validator;

import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.stereotype.Component;

@Component
public class EmptyLineValidator implements TokenValidator {

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return sourceCodeTokens[0].equals("");
    }
}