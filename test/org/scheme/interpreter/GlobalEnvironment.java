package org.scheme.interpreter;

public class GlobalEnvironment extends SEnvironment {

    public GlobalEnvironment(SFrame frame) {
        super(null, frame);
    }

    public Object lookupVariableValue(String varName) {
        Object value = frame.lookup(varName);
        if (value == null) throw new UnboundVariableException();
        return value;
    }

    public void setVariableValue(String varName, String varValue) {
        if (!frame.modify(varName, varValue))
            throw new UnboundVariableException();
    }
}
