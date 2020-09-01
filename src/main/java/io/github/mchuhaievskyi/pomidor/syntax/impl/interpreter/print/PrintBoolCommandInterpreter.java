package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.print;

import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintBoolCommandInterpreter extends SpecificPrintCommandInterpreter<Boolean> {

    @Autowired
    public PrintBoolCommandInterpreter(SpecificExpressionInterpreter<Boolean> boolExpressionTokenInterpreter) {

        super(boolExpressionTokenInterpreter);
    }
}