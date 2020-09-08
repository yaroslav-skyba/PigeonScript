package io.github.yarunkan.ps.syntax.impl;

import io.github.yarunkan.ps.syntax.SourceFileNameValidator;

public class SourceFileNameValidatorImpl implements SourceFileNameValidator {

    @Override
    public boolean validate(String fileName) {

        if (fileName != null) {

            return fileName.matches("[^:?\"<>|]+\\.ps");
        }

        return false;
    }
}