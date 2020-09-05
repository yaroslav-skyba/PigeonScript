package io.github.mchuhaievskyi.pomidor.database.variables;

import java.util.*;

public class VariablesDatabaseImpl implements VariablesDatabase {

    private static VariablesDatabaseImpl variablesDatabase;

    private final Map<String, String> variables = new HashMap<>();

    private VariablesDatabaseImpl(){}

    public static VariablesDatabaseImpl getInstance() {

        if (variablesDatabase == null) {

            variablesDatabase = new VariablesDatabaseImpl();
        }

        return variablesDatabase;
    }

    @Override
    public String getVariable(String variableName) {

        return variables.get(variableName);
    }

    @Override
    public void setVariable(String variableName, String variableValue) {

        variables.put(variableName, variableValue);
    }
}