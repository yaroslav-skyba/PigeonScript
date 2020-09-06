package io.github.yarunkan.pomidor.syntax.impl.validator;

import io.github.yarunkan.pomidor.database.labels.LabelDatabase;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GotoValidator implements TokenValidator {

    private final TokenValidator gotoKeywordValidator;
    private final LabelDatabase labelDatabaseImpl;

    @Autowired
    public GotoValidator(TokenValidator gotoKeywordValidator, LabelDatabase labelDatabaseImpl) {

        this.gotoKeywordValidator = gotoKeywordValidator;
        this.labelDatabaseImpl = labelDatabaseImpl;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        if (!gotoKeywordValidator.validate(sourceCodeTokens[0])) {

            return false;
        }

        return labelDatabaseImpl.isPresent(sourceCodeTokens[1]);
    }

    @Override
    public int getExpectedTokensCount() {

        return 2;
    }
}