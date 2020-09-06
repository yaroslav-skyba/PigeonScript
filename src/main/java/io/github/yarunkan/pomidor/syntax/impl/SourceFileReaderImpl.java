package io.github.yarunkan.pomidor.syntax.impl;

import io.github.yarunkan.pomidor.syntax.*;
import java.io.*;

public class SourceFileReaderImpl implements SourceFileReader {

    private final SourceFileNameValidator sourceFileNameValidatorImpl;

    public SourceFileReaderImpl(SourceFileNameValidator sourceFileNameValidatorImpl) {

        this.sourceFileNameValidatorImpl = sourceFileNameValidatorImpl;
    }

    @Override
    public String[] read(String filePath) {

        if (sourceFileNameValidatorImpl.validate(filePath)) {

            final StringBuilder fileLines = new StringBuilder();

            try (Reader reader = new BufferedReader(new FileReader(filePath))) {

                int fileSymbol;

                while ((fileSymbol = reader.read()) != -1) {

                    fileLines.append((char)fileSymbol);
                }
            } catch (IOException e) {

                System.out.println(e.getMessage());
            }

            return fileLines.toString().split("\n");
        }

        throw new IllegalArgumentException("A source file has a wrong path or the file does not exist");
    }
}