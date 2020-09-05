package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LabelSchema implements TokenSchema {

    private final TokenValidator labelValidator;
    private final TokenParser labelParser;

    @Autowired
    public LabelSchema(TokenValidator labelValidator, TokenParser labelParser) {

        this.labelValidator = labelValidator;
        this.labelParser = labelParser;
    }

    @Override
    public String getDescription() {

        return  "14) <label-declaration> --> label <label-name>\n" +
                "15) <label-name> --> <var-name-symbols>";
    }

    @Override
    public TokenValidator getTokenValidator() {

        return labelValidator;
    }

    @Override
    public TokenParser getTokenParser() {

        return labelParser;
    }
}