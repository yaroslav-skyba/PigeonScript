package io.github.yarunkan.pomidor.syntax;

import org.springframework.context.ApplicationContext;

public interface TokenInterpreter {

    boolean interpret(String fileLine, ApplicationContext context);
}