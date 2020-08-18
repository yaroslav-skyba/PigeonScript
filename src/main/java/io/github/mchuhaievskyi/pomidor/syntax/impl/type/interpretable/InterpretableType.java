package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;

public interface InterpretableType extends PomidorTokenType {

    PomidorTokenInterpreter getInterpreter();
}