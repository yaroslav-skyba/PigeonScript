package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LiteralSchema implements TokenSchema {

    private final TokenValidator literalValidator;
    private final TokenParser literalParser;

    @Autowired
    public LiteralSchema(TokenValidator literalValidator,
                         TokenParser literalParser) {

        this.literalValidator = literalValidator;
        this.literalParser = literalParser;
    }

    @Override
    public String getDescription() {

        return "2) <literal> --> <bool-literal> | <int-literal> | <string-literal>\n" +
                "3) <bool-literal> --> true | false\n" +
                "4) <int-literal> --> - <numbers> | <numbers>\n" +
                "5) <string-literal> --> \" <any-symbols> \"\n";
    }

    @Override
    public TokenValidator getTokenValidator() {
        return literalValidator;
    }

    @Override
    public TokenParser getTokenParser() {
        return literalParser;
    }
}