package io.github.mchuhaievskyi.pomidor.syntax;

import org.springframework.context.ApplicationContext;

public interface TokenInterpreter {

    boolean interpret(String fileLine, ApplicationContext context);
}