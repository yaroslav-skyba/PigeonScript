package io.github.yarunkan.pomidor.syntax.impl.interpreter;

public interface InterpretationBlocker {

    default boolean getIsNotInterpretationBlocked() {

        return true;
    }
}