package io.github.yarunkan.pomidor.syntax.impl.validator.declaration;

import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class VarDeclarationValidator implements TokenValidator {

    private final Set<SpecificVarDeclarationValidator> specificVarDeclarationValidators;

    @Autowired
    public VarDeclarationValidator(Set<SpecificVarDeclarationValidator> specificVarDeclarationValidators) {

        this.specificVarDeclarationValidators = specificVarDeclarationValidators;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        return specificVarDeclarationValidators.stream().anyMatch(v -> v.validate(sourceCodeTokens));
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 == 0;
    }

    @Override
    public int getExpectedTokensCount() {

        return 4;
    }
}