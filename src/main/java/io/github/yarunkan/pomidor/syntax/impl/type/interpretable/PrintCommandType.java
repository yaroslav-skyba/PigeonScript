package io.github.yarunkan.pomidor.syntax.impl.type.interpretable;

import io.github.yarunkan.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCommandType implements InterpretableType {

    private final AbstractTokenInterpreter printCommandInterpreter;

    @Autowired
    private TokenSchema printCommandSchema;

    @Autowired
    public PrintCommandType(AbstractTokenInterpreter printCommandInterpreter) {

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
    public AbstractTokenInterpreter getInterpreter() {

        return printCommandInterpreter;
    }
}