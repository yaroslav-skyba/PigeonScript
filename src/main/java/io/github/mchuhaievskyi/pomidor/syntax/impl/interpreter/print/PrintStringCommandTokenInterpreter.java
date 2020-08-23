package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.print;

import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression.SpecificExpressionTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintStringCommandTokenInterpreter extends SpecificPrintCommandTokenInterpreter<String> {

    @Autowired
    public PrintStringCommandTokenInterpreter(SpecificExpressionTokenInterpreter<String> stringExpressionTokenInterpreter) {

        super(stringExpressionTokenInterpreter);
    }

    @Override
    void printInterpretationResult(String result) {

        super.printInterpretationResult(result.replace("\"", ""));
    }
}