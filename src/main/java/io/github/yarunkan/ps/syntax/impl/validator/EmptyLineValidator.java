package io.github.yarunkan.ps.syntax.impl.validator;

import io.github.yarunkan.ps.syntax.token.TokenValidator;
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