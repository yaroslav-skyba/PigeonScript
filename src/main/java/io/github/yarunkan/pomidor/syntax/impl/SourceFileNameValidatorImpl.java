package io.github.yarunkan.pomidor.syntax.impl;

import io.github.yarunkan.pomidor.syntax.SourceFileNameValidator;

public class SourceFileNameValidatorImpl implements SourceFileNameValidator {

    @Override
    public boolean validate(String fileName) {

        if (fileName != null) {

            return fileName.matches("[^:?\"<>|]+\\.ps");
        }

        return false;
    }
}