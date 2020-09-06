package io.github.yarunkan.pomidor.syntax.impl.validator.print;

import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class PrintCommandValidator implements TokenValidator {

    private final Set<SpecificPrintCommandValidator<?>> specificPrintCommandValidators;

    @Autowired
    public PrintCommandValidator(Set<SpecificPrintCommandValidator<?>> specificPrintCommandValidators) {

        this.specificPrintCommandValidators = specificPrintCommandValidators;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        return specificPrintCommandValidators.stream().anyMatch(v -> v.validate(sourceCodeTokens));
    }

    @Override
    public int getExpectedTokensCount() {

        return 2;
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 == 0;
    }
}