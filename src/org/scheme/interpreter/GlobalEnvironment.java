package org.scheme.interpreter;

import java.util.ArrayList;

public class GlobalEnvironment extends SEnvironment {

    public GlobalEnvironment(SFrame frame) {
        super(null, frame);
    }

    public GlobalEnvironment() {
        this(new SFrame(new ArrayList(), new ArrayList()));
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
