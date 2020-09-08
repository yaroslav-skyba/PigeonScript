package io.github.yarunkan.ps.syntax.impl.interpreter.print;

import io.github.yarunkan.ps.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintStringCommandInterpreter extends SpecificPrintCommandInterpreter<String> {

    @Autowired
    public PrintStringCommandInterpreter(SpecificExpressionInterpreter<String> stringExpressionTokenInterpreter) {

        super(stringExpressionTokenInterpreter);
    }

    @Override
    void printInterpretationResult(String result) {

        super.printInterpretationResult(result.replace("\"", ""));
    }
}