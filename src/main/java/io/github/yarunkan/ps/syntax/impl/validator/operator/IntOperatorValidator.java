package io.github.yarunkan.ps.syntax.impl.validator.operator;

import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class IntOperatorValidator implements SpecificOperatorValidator {

    @Override
    public Set<String> getOperatorSymbols() {
        return Set.of("+", "-", "*", "/");
    }
}