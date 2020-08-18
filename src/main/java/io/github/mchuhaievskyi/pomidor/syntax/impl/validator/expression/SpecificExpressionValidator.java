package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.expression;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.stereotype.Component;

@Component
public interface SpecificExpressionValidator<T> extends PomidorTokenValidator {

    Class<T> getType();

    @Override
    default boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 != 0;
    }
}