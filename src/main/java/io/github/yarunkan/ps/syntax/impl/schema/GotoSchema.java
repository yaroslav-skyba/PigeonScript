package io.github.yarunkan.ps.syntax.impl.schema;

import io.github.yarunkan.ps.syntax.token.TokenParser;
import io.github.yarunkan.ps.syntax.token.TokenSchema;
import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GotoSchema implements TokenSchema {

    private final TokenValidator gotoValidator;
    private final TokenParser gotoParser;

    @Autowired
    public GotoSchema(TokenValidator gotoValidator, TokenParser gotoParser) {

        this.gotoValidator = gotoValidator;
        this.gotoParser = gotoParser;
    }

    @Override
    public String getDescription() {

        return "A goto token";
    }

    @Override
    public TokenValidator getTokenValidator() {

        return gotoValidator;
    }

    @Override
    public TokenParser getTokenParser() {

        return gotoParser;
    }
}