package io.github.mchuhaievskyi.pomidor.database;

public interface PomidorVariablesDatabase {

    String getVariable(String variableName);
    void setVariable(String variableName, String variableValue);
}