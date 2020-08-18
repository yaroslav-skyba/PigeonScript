package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCommandType implements InterpretableType {

    private final PomidorTokenInterpreter printCommandTokenInterpreter;

    @Autowired
    private PomidorTokenSchema printCommandSchema;

    @Autowired
    public PrintCommandType(PomidorTokenInterpreter printCommandTokenInterpreter) {

        this.printCommandTokenInterpreter = printCommandTokenInterpreter;
    }

    @Override
    public String getName() {
        return "Print command token";
    }

    @Override
    public PomidorTokenSchema getSchema() {
        return printCommandSchema;
    }

    @Override
    public PomidorTokenInterpreter getInterpreter() {

        return printCommandTokenInterpreter;
    }
}