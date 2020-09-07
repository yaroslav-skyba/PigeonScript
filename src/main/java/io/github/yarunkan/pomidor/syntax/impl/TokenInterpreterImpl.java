package io.github.yarunkan.pomidor.syntax.impl;

import io.github.yarunkan.pomidor.syntax.PSTokenParser;
import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.type.interpretable.InterpretableType;
import io.github.yarunkan.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class TokenInterpreterImpl implements io.github.yarunkan.pomidor.syntax.TokenInterpreter {

    private final Set<InterpretableType> interpretableTypes;

    @Autowired
    public TokenInterpreterImpl(Set<InterpretableType> interpretableTypes) {

        this.interpretableTypes = interpretableTypes;
    }

    @Override
    public boolean interpret(String fileLine, ApplicationContext context) {

        for (final InterpretableType interpretableType : interpretableTypes) {

            final TokenType tokenBean = context.getBean(interpretableType.getClass());
            final PSTokenParser parser = new PSTokenParserImpl(fileLine, tokenBean);
            final Token token;

            try {

                token = parser.takeNextToken();

            } catch (IllegalStateException e) {

                continue;
            }

            final AbstractTokenInterpreter interpreter = interpretableType.getInterpreter();

            if (!interpreter.isNotInterpretationBlocked()) {

                return true;
            }

            return interpreter.interpret(token);
        }

        return false;
    }
}