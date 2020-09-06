package io.github.yarunkan.pomidor.syntax.impl.schema;

import io.github.yarunkan.pomidor.syntax.token.TokenParser;
import io.github.yarunkan.pomidor.syntax.token.TokenSchema;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatorSchema implements TokenSchema {

    private final TokenValidator operatorValidator;
    private final TokenParser operatorParser;

    @Autowired
    public OperatorSchema(TokenValidator operatorValidator,
                          TokenParser operatorParser) {

        this.operatorValidator = operatorValidator;
        this.operatorParser = operatorParser;
    }

    @Override
    public String getDescription() {

        return "19) <expression-operator> --> <int-operator> | <bool-operator> | <string-operator>\n" +
                "20) <int-operator> --> +, -, *, /\n" +
                "21) <bool-operator> --> &, |\n" +
                "22) <string-operator> --> +\n";
    }

    @Override
    public TokenValidator getTokenValidator() {
        return operatorValidator;
    }

    @Override
    public TokenParser getTokenParser() {
        return operatorParser;
    }
}