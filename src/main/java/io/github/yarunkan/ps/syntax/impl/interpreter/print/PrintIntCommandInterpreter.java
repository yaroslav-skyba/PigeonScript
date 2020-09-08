package io.github.yarunkan.ps.syntax.impl.interpreter.print;

import io.github.yarunkan.ps.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintIntCommandInterpreter extends SpecificPrintCommandInterpreter<Long> {

    @Autowired
    public PrintIntCommandInterpreter(SpecificExpressionInterpreter<Long> intExpressionTokenInterpreter) {

        super(intExpressionTokenInterpreter);
    }
}