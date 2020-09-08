package io.github.yarunkan.ps.syntax.token;

import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.impl.interpreter.condition.InterpretationBlocker;
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