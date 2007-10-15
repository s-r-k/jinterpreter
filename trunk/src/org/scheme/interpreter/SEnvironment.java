package org.scheme.interpreter;

import java.util.List;

public class SEnvironment {
    private SEnvironment enclosing;
    protected SFrame frame;

    public SEnvironment(SEnvironment enclosing, SFrame frame) {
        this.enclosing = enclosing;
        this.frame = frame;
    }

    /**
     * Adds to the first frame in the environment <env>
     * a new binding that associates the variable <var> with the value <value>.
     */
    public void defineVariable(String varName, String varValue) {
        frame.defineVariable(varName, varValue);
    }

    /**
     * Returns the value that is bound to the symbol <varName> in the environment,
     * or signals an error if the variable is unbound.
     */
    public Object lookupVariableValue(String varName) {
        Object value = frame.lookup(varName);
        return value == null ? enclosing.lookupVariableValue(varName) : value;
    }

    /**
     * Changes the binding of the variable <var> in the environment <env>
     * so that the variable is now bound to the value <new-value>,
     * or signals an error if the variable is unbound.
     */
    public void setVariableValue(String varName, String varValue) {
        if (!frame.modify(varName, varValue))
            enclosing.setVariableValue(varName, varValue);
    }

    /**
     * returns a new environment, consisting of a new frame in which the symbols in the list <variables>
     * are bound to the corresponding elements in the list <values>, where the enclosing environment is
     * the environment <base-env>.
     */
    public SEnvironment extend(List names, List values) {
        SFrame frame = new SFrame(names, values);
        return new SEnvironment(this, frame);
    }
}
