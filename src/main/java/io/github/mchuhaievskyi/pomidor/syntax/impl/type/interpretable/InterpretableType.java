package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;

public interface InterpretableType extends TokenType {

    TokenInterpreter getInterpreter();
}