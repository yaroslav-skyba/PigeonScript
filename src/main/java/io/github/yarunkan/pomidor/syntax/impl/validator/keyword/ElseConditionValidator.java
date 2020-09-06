package io.github.yarunkan.pomidor.syntax.impl.validator.keyword;

import org.springframework.stereotype.Component;

@Component
public class ElseConditionValidator implements SpecificKeywordValidator {

    @Override
    public String getKeywordConstant() {
        return "else";
    }
}