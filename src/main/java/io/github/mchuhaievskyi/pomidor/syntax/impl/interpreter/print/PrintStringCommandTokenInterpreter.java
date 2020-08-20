package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.print;

import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation.SpecificOperationTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintStringCommandTokenInterpreter extends SpecificPrintCommandTokenInterpreter<String> {

    @Autowired
    public PrintStringCommandTokenInterpreter(SpecificOperationTokenInterpreter<String> stringOperationTokenInterpreter) {

        super(stringOperationTokenInterpreter);
    }

    @Override
    void printInterpretationResult(String result) {

        super.printInterpretationResult(result.replace("\"", ""));
    }
}