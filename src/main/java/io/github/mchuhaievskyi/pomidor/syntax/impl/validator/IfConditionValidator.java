package io.github.mchuhaievskyi.pomidor.syntax.impl.validator;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IfConditionValidator implements PomidorTokenValidator {

    private final PomidorTokenValidator ifKeywordValidator;
    private final PomidorTokenValidator boolExpressionValidator;
    private final PomidorTokenValidator thenKeywordValidator;

    @Autowired
    public IfConditionValidator(PomidorTokenValidator ifKeywordValidator,
                                PomidorTokenValidator boolExpressionValidator,
                                PomidorTokenValidator thenKeywordValidator) {

        this.ifKeywordValidator = ifKeywordValidator;
        this.boolExpressionValidator = boolExpressionValidator;
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

        final int sourceCodeTokensCount = sourceCodeTokens.length;
        final int keywordTokensCount = 2;
        final int expressionTokensCount = sourceCodeTokensCount - keywordTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, 1, expressionTokens, 0, expressionTokensCount);

        if (!boolExpressionValidator.validate(expressionTokens)) {

            return false;
        }

        return thenKeywordValidator.validate(sourceCodeTokens[sourceCodeTokensCount-1]);
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