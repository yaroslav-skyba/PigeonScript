package io.github.yarunkan.pomidor.syntax.impl.validator.operator;

import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class BoolOperatorValidator implements SpecificOperatorValidator<Boolean> {

    @Override
    public Set<String> getOperatorSymbols() {
        return Set.of("&", "|");
    }

    @Override
    public Class<Boolean> getRelatedType() {

        return Boolean.class;
    }
}