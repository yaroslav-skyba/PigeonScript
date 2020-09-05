package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarNameSchema implements TokenSchema {

    private final TokenValidator varNameValidator;
    private final TokenParser varNameParser;

    @Autowired
    public VarNameSchema(TokenValidator varNameValidator,
                         TokenParser varNameParser) {

        this.varNameValidator = varNameValidator;
        this.varNameParser = varNameParser;
    }

    @Override
    public String getDescription() {

        return "11) <var-name> --> <var-name-symbols>\n" +
                "12) <var-name-symbols> --> <var-name-symbol> <var-name-symbols> | <var-name-symbol>\n" +
                "13) <var-name-symbol> --> a .. z , A .. Z, _\n";
    }

    @Override
    public TokenValidator getTokenValidator() {
        return varNameValidator;
    }

    @Override
    public TokenParser getTokenParser() {
        return varNameParser;
    }
}