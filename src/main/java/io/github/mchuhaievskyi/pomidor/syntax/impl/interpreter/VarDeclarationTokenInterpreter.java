package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter;

import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabase;
import io.github.mchuhaievskyi.pomidor.database.PomidorVariablesDatabaseImpl;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import org.springframework.stereotype.Component;

@Component
public class VarDeclarationTokenInterpreter extends PomidorTokenInterpreter {

    private final PomidorVariablesDatabase variablesDatabase = PomidorVariablesDatabaseImpl.getInstance();

    @Override
    public boolean interpret(PomidorToken token) {

        variablesDatabase.setVariable(getTokenSourceCode(token, 1), getTokenSourceCode(token, 3));
        return true;
    }

    private String getTokenSourceCode(PomidorToken token, int subTokenIndex) {

        return token.getSubTokens().get(subTokenIndex).getSourceCode();
    }
}