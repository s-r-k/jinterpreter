package org.scheme.interpreter;

import java.util.List;

public interface IEnvironment {
    void defineVariable(String varName, String varValue);

    Object lookupVariableValue(String varName);

    void setVariableValue(String varName, String varValue);

    SEnvironment extend(List names, List values, IEnvironment baseEnv);
}
