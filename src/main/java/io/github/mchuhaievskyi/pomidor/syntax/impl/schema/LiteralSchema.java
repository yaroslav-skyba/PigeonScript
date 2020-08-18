package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LiteralSchema implements PomidorTokenSchema {

    private final PomidorTokenValidator literalValidator;
    private final PomidorTokenParser literalTokenParser;

    @Autowired
    public LiteralSchema(PomidorTokenValidator literalValidator,
                         PomidorTokenParser literalTokenParser) {

        this.literalValidator = literalValidator;
        this.literalTokenParser = literalTokenParser;
    }

    @Override
    public String getDescription() {

        return "2) <literal> --> <bool-literal> | <int-literal> | <string-literal>\n" +
                "3) <bool-literal> --> true | false\n" +
                "4) <int-literal> --> - <numbers> | <numbers>\n" +
                "5) <string-literal> --> \" <any-symbols> \"\n";
    }

    @Override
    public PomidorTokenValidator getTokenValidator() {
        return literalValidator;
    }

    @Override
    public PomidorTokenParser getTokenParser() {
        return literalTokenParser;
    }
}