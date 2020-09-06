package io.github.yarunkan.pomidor.syntax.impl.schema;

import io.github.yarunkan.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCommandSchema implements TokenSchema {

    private final TokenValidator printCommandValidator;
    private final TokenParser printCommandParser;

    @Autowired
    public PrintCommandSchema(TokenValidator printCommandValidator,
                              TokenParser printCommandParser) {

        this.printCommandValidator = printCommandValidator;
        this.printCommandParser = printCommandParser;
    }

    @Override
    public String getDescription() {

        return "24) <print> --> print <expression>\n";
    }

    @Override
    public TokenValidator getTokenValidator() {

        return printCommandValidator;
    }

    @Override
    public TokenParser getTokenParser() {

        return printCommandParser;
    }
}