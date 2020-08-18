package io.github.mchuhaievskyi.pomidor.syntax.impl.validator;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCommandValidator implements PomidorTokenValidator {

    private final PomidorTokenValidator printKeywordValidator;
    private final PomidorTokenValidator operandValidator;

    @Autowired
    public PrintCommandValidator(PomidorTokenValidator printKeywordValidator,
                                 PomidorTokenValidator operandValidator) {

        this.printKeywordValidator = printKeywordValidator;
        this.operandValidator = operandValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        if (!printKeywordValidator.validate(sourceCodeTokens[0])) {

            return false;
        }

        return operandValidator.validate(sourceCodeTokens[1]);
    }

    @Override
    public int getExpectedTokensCount() {

        return 2;
    }
}