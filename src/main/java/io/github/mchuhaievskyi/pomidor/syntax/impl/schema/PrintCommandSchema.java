package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCommandSchema implements PomidorTokenSchema {

    private final PomidorTokenValidator printCommandValidator;
    private final PomidorTokenParser printCommandTokenParser;

    @Autowired
    public PrintCommandSchema(PomidorTokenValidator printCommandValidator,
                              PomidorTokenParser printCommandTokenParser) {

        this.printCommandValidator = printCommandValidator;
        this.printCommandTokenParser = printCommandTokenParser;
    }

    @Override
    public String getDescription() {

        return "24) <print> --> print <expression>\n";
    }

    @Override
    public PomidorTokenValidator getTokenValidator() {

        return printCommandValidator;
    }

    @Override
    public PomidorTokenParser getTokenParser() {

        return printCommandTokenParser;
    }
}