package org.scheme.interpreter;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class SEnvironmentTest extends TestCase {
    private SEnvironment root;

    protected void setUp() throws Exception {
        root = new GlobalEnvironment(new SFrame(listify("g-var-1", "g-var-2"), listify("one", "two")));
    }

    private List listify(String... words) {
        List<String> list = new ArrayList<String>();
        for (String word : words)
            list.add(word);
        return list;
    }

    public void testFreshVariableDefinition() {
        root.defineVariable("var-name", "var-value");
        assertEquals("var-value", root.lookupVariableValue("var-name"));
    }

    public void testExistingVariableReDefinition() {
        root.defineVariable("var-name", "var-value");
        assertEquals("var-value", root.lookupVariableValue("var-name"));
        root.defineVariable("var-name", "another-value");
        assertEquals("another-value", root.lookupVariableValue("var-name"));
    }

    public void testVariableMutation() {
        SEnvironment extendedL1 = extendEnvironment(root);
        extendedL1.setVariableValue("new-1", "new-2-value");
        assertEquals("new-2-value", extendedL1.lookupVariableValue("new-1"));
    }

    public void testIllegalVariableMutation() {
        SEnvironment extendedL1 = extendEnvironment(root);
        try {
            extendedL1.setVariableValue("non-existant", "some-value");
            fail("Should throw UnboundVariableException");
        } catch (UnboundVariableException e) {
        }
    }

    public void testEnvExtension() {
        SEnvironment newEnv = extendEnvironment(root);
        assertNotNull(newEnv);
    }

    public void testSimpleLookup() {
        SEnvironment newEnv = extendEnvironment(root);
        Object result = newEnv.lookupVariableValue("new-1");
        assertEquals("new-1-value", result);
    }

    public void testIfVariableInParentEnvCanBeFound() {
        SEnvironment newEnv = extendEnvironment(root);
        Object result = newEnv.lookupVariableValue("g-var-1");
        assertEquals("one", result);
    }

    public void testErrorIsThrownIfVariableCannotBeFound() {
        SEnvironment newEnv = extendEnvironment(root);
        try {
            newEnv.lookupVariableValue("g-var-non-existing");
            fail("UnboundVariableException expected to be thrown");
        } catch (UnboundVariableException e) {
        }
    }

    private SEnvironment extendEnvironment(SEnvironment baseEnv) {
        ArrayList<String> newNames = new ArrayList<String>();
        newNames.add("new-1");
        ArrayList<Object> newValues = new ArrayList<Object>();
        newValues.add("new-1-value");
        return baseEnv.extend(newNames, newValues);
    }

    public void testLookupAcrossEnclosingEnv() {
        SEnvironment level_1 = root.extend(listify("global-var-name"), listify("global-var-value"));

        ArrayList<String> newNames = new ArrayList<String>();
        newNames.add("level-2-var-1");
        ArrayList<Object> newValues = new ArrayList<Object>();
        newValues.add("level-2-value-1");

        SEnvironment level_2 = level_1.extend(newNames, newValues);

        Object value = level_2.lookupVariableValue("global-var-name");
        assertEquals("global-var-value", value);
    }

}
