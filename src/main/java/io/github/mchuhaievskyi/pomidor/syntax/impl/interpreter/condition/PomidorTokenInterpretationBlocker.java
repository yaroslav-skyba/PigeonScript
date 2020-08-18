package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.condition;

public interface PomidorTokenInterpretationBlocker {

    default boolean getIsNotInterpretationBlocked() {

        return true;
    }
}