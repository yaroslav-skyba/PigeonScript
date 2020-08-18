package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter;

import io.github.mchuhaievskyi.pomidor.database.*;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.condition.PomidorTokenInterpretationBlocker;
import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class PrintCommandTokenInterpreter extends PomidorTokenInterpreter {

    private final PomidorVariablesDatabase variablesDatabase = PomidorVariablesDatabaseImpl.getInstance();

    @Override
    public boolean interpret(PomidorToken token) {

        String operand = token.getSubTokens().get(1).getSourceCode();
        operand = Objects.requireNonNullElse(variablesDatabase.getVariable(operand), operand).replace("\"", "");

        System.out.println(operand);

        return true;
    }
}