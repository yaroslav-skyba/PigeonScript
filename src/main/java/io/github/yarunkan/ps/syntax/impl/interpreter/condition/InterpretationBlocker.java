package io.github.yarunkan.ps.syntax.impl.interpreter.condition;

public interface InterpretationBlocker {

    default boolean getIsNotInterpretationBlocked() {

        return true;
    }
}