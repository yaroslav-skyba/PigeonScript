package io.github.yarunkan.pomidor.syntax.impl.validator;

import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class VarNameValidator implements TokenValidator {

    private final TokenValidator keywordValidator;
    private final TokenValidator literalValidator;
    private final TokenValidator operatorValidator;

    @Autowired
    @Lazy
    public VarNameValidator(TokenValidator keywordValidator, TokenValidator literalValidator, TokenValidator operatorValidator) {

        this.keywordValidator = keywordValidator;
        this.literalValidator = literalValidator;
        this.operatorValidator = operatorValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return  sourceCodeTokens[0] != null &&
                sourceCodeTokens[0].matches("[a-zA-Z_]+") &&
                !keywordValidator.validate(sourceCodeTokens[0]) &&
                !literalValidator.validate(sourceCodeTokens[0]) &&
                !operatorValidator.validate(sourceCodeTokens[0]);
    }
}