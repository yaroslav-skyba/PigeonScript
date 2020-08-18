package io.github.mchuhaievskyi.pomidor.syntax.impl.validator;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarDeclarationValidator implements PomidorTokenValidator {

    private final PomidorTokenValidator varKeywordValidator;
    private final PomidorTokenValidator varNameValidator;
    private final PomidorTokenValidator assigmentOperatorValidator;
    private final PomidorTokenValidator literalValidator;

    @Autowired
    public VarDeclarationValidator(PomidorTokenValidator varKeywordValidator,
                                   PomidorTokenValidator varNameValidator,
                                   PomidorTokenValidator assigmentOperatorValidator,
                                   PomidorTokenValidator literalValidator) {

        this.varKeywordValidator = varKeywordValidator;
        this.varNameValidator = varNameValidator;
        this.assigmentOperatorValidator = assigmentOperatorValidator;
        this.literalValidator = literalValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        if (!varKeywordValidator.validate(sourceCodeTokens[0])) {

            return false;
        }

        if (!varNameValidator.validate(sourceCodeTokens[1])) {

            return false;
        }

        if (!assigmentOperatorValidator.validate(sourceCodeTokens[2])) {

            return false;
        }

        return literalValidator.validate(sourceCodeTokens[3]);
    }

    @Override
    public int getExpectedTokensCount() {
        return 4;
    }
}