package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter;

public interface InterpretationBlocker {

    default boolean getIsNotInterpretationBlocked() {

        return true;
    }
}