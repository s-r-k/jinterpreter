package org.scheme.interpreter;

import junit.framework.TestCase;

public class EvaluatorTest extends TestCase {

    public void testNumericLiterals() {
        SEvaluator evaluator = new SEvaluator();
        Object result = evaluator.eval("1", new GlobalEnvironment());
        assertEquals("1", result);
        result = evaluator.eval("2.5", new GlobalEnvironment());
        assertEquals("2.5", result);
    }

    public void testStringLiterals() {
        SEvaluator evaluator = new SEvaluator();
        Object result = evaluator.eval("Test", new GlobalEnvironment());
        assertEquals("Test", result);
    }

}
