package io.github.mchuhaievskyi.pomidor.syntax.impl.validator;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IfConditionValidator implements TokenValidator {

    private final TokenValidator ifKeywordValidator;
    private final TokenValidator expressionValidator;
    private final TokenValidator thenKeywordValidator;

    @Autowired
    public IfConditionValidator(TokenValidator ifKeywordValidator, TokenValidator expressionValidator, TokenValidator thenKeywordValidator) {

        this.ifKeywordValidator = ifKeywordValidator;
        this.expressionValidator = expressionValidator;
        this.thenKeywordValidator = thenKeywordValidator;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        if (!ifKeywordValidator.validate(sourceCodeTokens[0])) {

            return false;
        }

        final int tokensCount = sourceCodeTokens.length;
        final int expressionTokensCount = tokensCount - 2;
        final String[] expressionTokens = new String[expressionTokensCount];

        final int tokensArrayCopySrcPos = 1;

        System.arraycopy(sourceCodeTokens, tokensArrayCopySrcPos, expressionTokens, 0, expressionTokensCount);

        if (!expressionValidator.validate(expressionTokens)) {

            return false;
        }

        return thenKeywordValidator.validate(sourceCodeTokens[tokensCount - 1]);
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 != 0;
    }

    @Override
    public int getExpectedTokensCount() {

        return 3;
    }
}