package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.print;

import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation.SpecificOperationTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintBoolCommandTokenInterpreter extends SpecificPrintCommandTokenInterpreter<Boolean> {

    @Autowired
    public PrintBoolCommandTokenInterpreter(SpecificOperationTokenInterpreter<Boolean> boolOperationTokenInterpreter) {

        super(boolOperationTokenInterpreter);
    }
}