package io.github.mchuhaievskyi.pomidor.syntax.token;

import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.InterpretationBlocker;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;

public abstract class AbstractTokenInterpreter {

    @Autowired
    private Set<InterpretationBlocker> interpretationBlockers;

    public boolean isNotInterpretationBlocked() {

        for (InterpretationBlocker interpretationBlocker : interpretationBlockers) {

            if (!interpretationBlocker.getIsNotInterpretationBlocked()) {

                return false;
            }
        }

        return true;
    }

    public abstract boolean interpret(Token token);
}