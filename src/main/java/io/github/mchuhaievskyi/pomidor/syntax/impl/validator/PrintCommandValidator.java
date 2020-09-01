package io.github.mchuhaievskyi.pomidor.syntax.impl.validator;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCommandValidator implements TokenValidator {

    private final TokenValidator printKeywordValidator;
    private final TokenValidator expressionValidator;

    @Autowired
    public PrintCommandValidator(TokenValidator printKeywordValidator, TokenValidator expressionValidator) {

        this.printKeywordValidator = printKeywordValidator;
        this.expressionValidator = expressionValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        if (!printKeywordValidator.validate(sourceCodeTokens[0])) {

            return false;
        }

        final int notExpressionTokensCount = 1;
        final int expressionTokensCount = sourceCodeTokens.length - notExpressionTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, 1, expressionTokens, 0, expressionTokensCount);

        return expressionValidator.validate(expressionTokens);
    }

    @Override
    public int getExpectedTokensCount() {

        return 2;
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 == 0;
    }
}