package io.github.yarunkan.pomidor.syntax.impl.interpreter.condition;

import io.github.yarunkan.pomidor.syntax.impl.interpreter.InterpretationBlocker;
import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;

public abstract class ConditionInterpreter extends AbstractTokenInterpreter implements InterpretationBlocker {

    public abstract void setIsConditionTrue(Boolean isConditionTrue);
    public abstract Boolean getIsConditionTrue();

    @Override
    public boolean getIsNotInterpretationBlocked() {

        final Boolean isConditionTrue = getIsConditionTrue();

        return isConditionTrue == null || isConditionTrue;
    }

    @Override
    public boolean isNotInterpretationBlocked() {

        return true;
    }
}