package io.github.yarunkan.pomidor.syntax.impl.type.interpretable;

import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenType;

public interface InterpretableType extends TokenType {

    AbstractTokenInterpreter getInterpreter();
}