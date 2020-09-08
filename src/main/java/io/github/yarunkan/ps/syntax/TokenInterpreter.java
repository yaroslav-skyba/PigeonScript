package io.github.yarunkan.ps.syntax;

import org.springframework.context.ApplicationContext;

public interface TokenInterpreter {

    boolean interpret(String fileLine, ApplicationContext context);
}