package io.github.mchuhaievskyi.pomidor.syntax.token;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.condition.PomidorTokenInterpretationBlocker;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;

public abstract class PomidorTokenInterpreter {

    @Autowired
    private Set<PomidorTokenInterpretationBlocker> pomidorTokenInterpretationBlockers;

    public boolean isNotInterpretationBlocked() {

        for (PomidorTokenInterpretationBlocker pomidorTokenInterpretationBlocker : pomidorTokenInterpretationBlockers) {

            if (!pomidorTokenInterpretationBlocker.getIsNotInterpretationBlocked()) {

                return false;
            }
        }

        return true;
    }

    public abstract boolean interpret(PomidorToken token);
}