package io.github.mchuhaievskyi.pomidor.syntax.impl.schema.keyword;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordSchema implements PomidorTokenSchema {

    private final PomidorTokenParser keywordTokenParser;
    private final PomidorTokenValidator keywordValidator;

    @Autowired
    public KeywordSchema(PomidorTokenParser keywordTokenParser,
                         PomidorTokenValidator keywordValidator) {

        this.keywordTokenParser = keywordTokenParser;
        this.keywordValidator = keywordValidator;
    }

    @Override
    public String getDescription() {

        return "10) <var-declaration> --> var <var-name> = <literal>\n" +
                "14) <label-declaration> --> label <label-name>\n" +
                "16) <goto> --> goto <label-name>\n" +
                "23) <if-else-block> --> if <expression> then <pomidor-statement>" +
                "| if <expression> then <pomidor-statement> else <pomidor-statement>\n" +
                "24) <print> --> print <expression>\n";
    }

    @Override
    public PomidorTokenValidator getTokenValidator() {
        return keywordValidator;
    }

    @Override
    public PomidorTokenParser getTokenParser() {
        return keywordTokenParser;
    }
}