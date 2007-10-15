package org.scheme.interpreter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SFrame {
    private Map<String, Object> bindings = new HashMap<String, Object>();

    public SFrame(List names, List values) {
        if (names.size() != values.size()) throw new RuntimeException("Args and values specified mismatch");
        bind(values, names);
    }

    private void bind(List names, List values) {
        Iterator vItr = names.iterator();
        for (Iterator nItr = values.iterator(); nItr.hasNext();)
            put((String) nItr.next(), vItr.next());
    }

    public void put(String name, Object value) {
        bindings.put(name, value);
    }

    public Object lookup(String varName) {
        return bindings.get(varName);
    }

    public boolean modify(String varName, Object varValue) {
        return bindings.containsKey(varName) && bindings.put(varName, varValue) != null;
    }

    public void defineVariable(String varName, String varValue) {
        bindings.put(varName, varValue);
    }
}
