package io.github.yarunkan.pomidor.database.variables;

public interface VariablesDatabase {

    String getVariable(String variableName);
    void setVariable(String variableName, String variableValue);
}