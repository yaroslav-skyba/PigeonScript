package io.github.mchuhaievskyi.pomidor.syntax.impl;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorParser;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.TokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable.InterpretableType;
import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class TokenInterpreterImpl implements TokenInterpreter {

    private final Set<InterpretableType> interpretableTypes;

    @Autowired
    public TokenInterpreterImpl(Set<InterpretableType> interpretableTypes) {

        this.interpretableTypes = interpretableTypes;
    }

    @Override
    public boolean interpret(String fileLine, ApplicationContext context) {

        for (final InterpretableType interpretableType : interpretableTypes) {

            final PomidorTokenType tokenBean = context.getBean(interpretableType.getClass());
            final PomidorParser parser = new PomidorParserImpl(fileLine, tokenBean);
            final PomidorToken token;

            try {

                token = parser.takeNextToken();

            } catch (IllegalStateException e) {

                continue;
            }

            final PomidorTokenInterpreter tokenInterpreter = interpretableType.getInterpreter();

            if (!tokenInterpreter.isNotInterpretationBlocked()) {

                return true;
            }

            return tokenInterpreter.interpret(token);
        }

        return false;
    }
}