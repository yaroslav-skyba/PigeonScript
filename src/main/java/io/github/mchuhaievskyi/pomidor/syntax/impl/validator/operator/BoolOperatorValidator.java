package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operator;

import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class BoolOperatorValidator implements SpecificOperatorValidator<Boolean> {

    @Override
    public Class<Boolean> getRelatedType() {
        return Boolean.class;
    }

    @Override
    public Set<String> getOperatorSymbols() {
        return Set.of("&", "|");
    }
}