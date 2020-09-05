package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;

public interface InterpretableType extends TokenType {

    AbstractTokenInterpreter getInterpreter();
}