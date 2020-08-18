package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.condition;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;

public abstract class ConditionTokenInterpreter extends PomidorTokenInterpreter implements PomidorTokenInterpretationBlocker {

    public abstract void setIsConditionTrue(Boolean isConditionTrue);
    public abstract Boolean getIsConditionTrue();

    @Override
    public boolean getIsNotInterpretationBlocked() {

        final Boolean isConditionTrue = getIsConditionTrue();

        return  isConditionTrue == null ||
                isConditionTrue;
    }

    @Override
    public boolean isNotInterpretationBlocked() {

        return true;
    }
}