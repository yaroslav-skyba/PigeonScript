package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCommandType implements InterpretableType {

    private final TokenInterpreter printCommandInterpreter;

    @Autowired
    private TokenSchema printCommandSchema;

    @Autowired
    public PrintCommandType(TokenInterpreter printCommandInterpreter) {

        this.printCommandInterpreter = printCommandInterpreter;
    }

    @Override
    public String getName() {

        return "A print command token";
    }

    @Override
    public TokenSchema getSchema() {

        return printCommandSchema;
    }

    @Override
    public TokenInterpreter getInterpreter() {

        return printCommandInterpreter;
    }
}