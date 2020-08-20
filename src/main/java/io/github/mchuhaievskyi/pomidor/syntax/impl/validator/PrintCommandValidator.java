package io.github.mchuhaievskyi.pomidor.syntax.impl.validator;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCommandValidator implements PomidorTokenValidator {

    private final PomidorTokenValidator printKeywordValidator;
    private final PomidorTokenValidator expressionValidator;

    @Autowired
    public PrintCommandValidator(PomidorTokenValidator printKeywordValidator,
                                 PomidorTokenValidator expressionValidator) {

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

        final int sourceCodeTokensCount = sourceCodeTokens.length;
        final int sourceCodeKeywordTokensCount = 1;
        final int sourceCodeExpressionTokensCount = sourceCodeTokensCount - sourceCodeKeywordTokensCount;
        final String[] sourceCodeExpressionTokens = new String[sourceCodeExpressionTokensCount];

        System.arraycopy(sourceCodeTokens, 1, sourceCodeExpressionTokens, 0, sourceCodeExpressionTokensCount);

        return expressionValidator.validate(sourceCodeExpressionTokens);
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