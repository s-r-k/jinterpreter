package org.basic.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Arguments {
    private Map<String, String> values = new HashMap<String, String>();

    public void add(String data, String type) {
        values.put(data, type);
    }
}
