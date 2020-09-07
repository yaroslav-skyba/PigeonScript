package io.github.yarunkan.pomidor.syntax.impl.interpreter.condition;

public interface InterpretationBlocker {

    default boolean getIsNotInterpretationBlocked() {

        return true;
    }
}