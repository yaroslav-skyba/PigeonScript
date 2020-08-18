package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarNameSchema implements PomidorTokenSchema {

    private final PomidorTokenValidator varNameValidator;
    private final PomidorTokenParser varNameTokenParser;

    @Autowired
    public VarNameSchema(PomidorTokenValidator varNameValidator,
                         PomidorTokenParser varNameTokenParser) {

        this.varNameValidator = varNameValidator;
        this.varNameTokenParser = varNameTokenParser;
    }

    @Override
    public String getDescription() {

        return "11) <var-name> --> <var-name-symbols>\n" +
                "12) <var-name-symbols> --> <var-name-symbol> <var-name-symbols> | <var-name-symbol>\n" +
                "13) <var-name-symbol> --> a .. z , A .. Z, _\n";
    }

    @Override
    public PomidorTokenValidator getTokenValidator() {
        return varNameValidator;
    }

    @Override
    public PomidorTokenParser getTokenParser() {
        return varNameTokenParser;
    }
}