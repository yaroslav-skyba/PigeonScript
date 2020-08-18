package io.github.mchuhaievskyi.pomidor.syntax.impl.validator;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarNameValidator implements PomidorTokenValidator {

    @Autowired
    private PomidorTokenValidator keywordValidator;
    @Autowired
    private PomidorTokenValidator literalValidator;
    @Autowired
    private PomidorTokenValidator operatorValidator;
    @Autowired
    private PomidorTokenValidator printCommandValidator;

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return  sourceCodeTokens[0] != null &&
                sourceCodeTokens[0].matches("[a-zA-Z_]+") &&
                !keywordValidator.validate(sourceCodeTokens[0]) &&
                !literalValidator.validate(sourceCodeTokens[0]) &&
                !operatorValidator.validate(sourceCodeTokens[0]) &&
                !printCommandValidator.validate(sourceCodeTokens[0]);
    }
}