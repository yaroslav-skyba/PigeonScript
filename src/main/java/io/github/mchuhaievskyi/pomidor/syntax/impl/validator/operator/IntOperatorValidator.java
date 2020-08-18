package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operator;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class IntOperatorValidator implements SpecificOperatorValidator<Integer> {

    @Override
    public Class<Integer> getRelatedType() {
        return Integer.class;
    }

    @Override
    public Set<String> getOperatorSymbols() {
        return Set.of("+", "-", "*", "/");
    }
}