package io.github.yarunkan.pomidor.syntax.impl.validator.operator;

import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class IntOperatorValidator implements SpecificOperatorValidator {

    @Override
    public Set<String> getOperatorSymbols() {
        return Set.of("+", "-", "*", "/");
    }
}