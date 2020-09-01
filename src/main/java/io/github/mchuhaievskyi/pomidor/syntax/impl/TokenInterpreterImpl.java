package io.github.mchuhaievskyi.pomidor.syntax.impl;

import io.github.mchuhaievskyi.pomidor.syntax.TokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable.InterpretableType;
import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class TokenInterpreterImpl implements io.github.mchuhaievskyi.pomidor.syntax.TokenInterpreter {

    private final Set<InterpretableType> interpretableTypes;

    @Autowired
    public TokenInterpreterImpl(Set<InterpretableType> interpretableTypes) {

        this.interpretableTypes = interpretableTypes;
    }

    @Override
    public boolean interpret(String fileLine, ApplicationContext context) {

        for (final InterpretableType interpretableType : interpretableTypes) {

            final TokenType tokenBean = context.getBean(interpretableType.getClass());
            final TokenParser tokenParser = new TokenParserImpl(fileLine, tokenBean);
            final Token token;

            try {

                token = tokenParser.takeNextToken();

            } catch (IllegalStateException e) {

                continue;
            }

            final TokenInterpreter interpreter = interpretableType.getInterpreter();

            if (!interpreter.isNotInterpretationBlocked()) {

                return true;
            }

            return interpreter.interpret(token);
        }

        return false;
    }
}