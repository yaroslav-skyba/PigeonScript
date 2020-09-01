package io.github.mchuhaievskyi.pomidor.database;

public interface VariablesDatabase {

    String getVariable(String variableName);
    void setVariable(String variableName, String variableValue);
}