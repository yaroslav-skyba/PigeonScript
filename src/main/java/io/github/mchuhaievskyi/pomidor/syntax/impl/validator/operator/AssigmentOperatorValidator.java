package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.operator;

import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class AssigmentOperatorValidator implements SpecificOperatorValidator<Object> {

    @Override
    public Class<Object> getRelatedType() {

        return Object.class;
    }

    @Override
    public Set<String> getOperatorSymbols() {

        return Set.of("=");
    }
}