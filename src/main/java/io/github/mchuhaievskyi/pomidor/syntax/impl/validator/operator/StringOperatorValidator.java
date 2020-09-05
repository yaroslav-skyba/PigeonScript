package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operator;

import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class StringOperatorValidator implements SpecificOperatorValidator<String> {

    @Override
    public Set<String> getOperatorSymbols() {
        return Set.of("+");
    }

    @Override
    public Class<String> getRelatedType() {

        return String.class;
    }
}