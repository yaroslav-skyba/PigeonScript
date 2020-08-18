package io.github.mchuhaievskyi.pomidor.syntax.impl;

import io.github.mchuhaievskyi.pomidor.syntax.SourceFileNameValidator;

public class SourceFileNameValidatorImpl implements SourceFileNameValidator {

    @Override
    public boolean validate(String fileName) {

        if (fileName != null) {

            return fileName.matches("[^:?\"<>|]+\\.pomidor");
        }

        return false;
    }
}