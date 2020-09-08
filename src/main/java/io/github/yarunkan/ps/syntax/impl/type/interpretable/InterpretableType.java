package io.github.yarunkan.ps.syntax.impl.type.interpretable;

import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.ps.syntax.token.TokenType;

public interface InterpretableType extends TokenType {

    AbstractTokenInterpreter getInterpreter();
}