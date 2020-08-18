package io.github.mchuhaievskyi.pomidor.database;

import java.util.*;

public class PomidorVariablesDatabaseImpl implements PomidorVariablesDatabase {

    private static PomidorVariablesDatabaseImpl pomidorVariablesDatabase;

    private final Map<String, String> pomidorVariables = new HashMap<>();

    private PomidorVariablesDatabaseImpl(){}

    public static PomidorVariablesDatabaseImpl getInstance() {

        if (pomidorVariablesDatabase == null) {

            pomidorVariablesDatabase = new PomidorVariablesDatabaseImpl();
        }

        return pomidorVariablesDatabase;
    }

    @Override
    public String getVariable(String variableName) {

        return pomidorVariables.get(variableName);
    }

    @Override
    public void setVariable(String variableName, String variableValue) {

        pomidorVariables.put(variableName, variableValue);
    }
}