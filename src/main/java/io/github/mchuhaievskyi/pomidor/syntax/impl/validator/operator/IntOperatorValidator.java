package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operator;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class IntOperatorValidator implements SpecificOperatorValidator<Long> {

    @Override
    public Class<Long> getRelatedType() {
        return Long.class;
    }

    @Override
    public Set<String> getOperatorSymbols() {
        return Set.of("+", "-", "*", "/");
    }
}