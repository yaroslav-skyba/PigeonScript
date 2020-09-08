package io.github.yarunkan.ps.syntax.impl.schema;

import io.github.yarunkan.ps.syntax.token.TokenParser;
import io.github.yarunkan.ps.syntax.token.TokenSchema;
import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmptyLineSchema implements TokenSchema {

    private final TokenValidator emptyLineValidator;
    private final TokenParser emptyLineParser;

    @Autowired
    public EmptyLineSchema(TokenValidator emptyLineValidator, TokenParser emptyLineParser) {

        this.emptyLineValidator = emptyLineValidator;
        this.emptyLineParser = emptyLineParser;
    }

    @Override
    public String getDescription() {

        return "";
    }

    @Override
    public TokenValidator getTokenValidator() {

        return emptyLineValidator;
    }

    @Override
    public TokenParser getTokenParser() {

        return emptyLineParser;
    }
}