package io.github.yarunkan.ps.syntax.impl.validator.keyword;

import org.springframework.stereotype.Component;

@Component
public class EndConditionValidator implements SpecificKeywordValidator {

    @Override
    public String getKeywordConstant() {
        return "end";
    }
}