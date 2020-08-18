package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatorSchema implements PomidorTokenSchema {

    private final PomidorTokenValidator operatorValidator;
    private final PomidorTokenParser operatorTokenParser;

    @Autowired
    public OperatorSchema(PomidorTokenValidator operatorValidator,
                          PomidorTokenParser operatorTokenParser) {

        this.operatorValidator = operatorValidator;
        this.operatorTokenParser = operatorTokenParser;
    }

    @Override
    public String getDescription() {

        return "19) <expression-operator> --> <int-operator> | <bool-operator> | <string-operator>\n" +
                "20) <int-operator> --> +, -, *, /\n" +
                "21) <bool-operator> --> &, |\n" +
                "22) <string-operator> --> +\n";
    }

    @Override
    public PomidorTokenValidator getTokenValidator() {
        return operatorValidator;
    }

    @Override
    public PomidorTokenParser getTokenParser() {
        return operatorTokenParser;
    }
}