package io.github.yarunkan.ps.database.variables;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class VariablesDatabaseImpl implements VariablesDatabase {

    private final static Map<String, String> VARIABLES = new HashMap<>();

    @Override
    public String get(String variableName) {

        return VARIABLES.get(variableName);
    }

    @Override
    public void add(String variableName, String variableValue) {

        VARIABLES.put(variableName, variableValue);
    }
}