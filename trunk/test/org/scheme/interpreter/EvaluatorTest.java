package org.scheme.interpreter;

import junit.framework.TestCase;

public class EvaluatorTest extends TestCase {

    public void testSelfEvaluatingExpressions() {
        SEvaluator evaluator = new SEvaluator();
        Object result = evaluator.eval(new SPrimitiveExpression(), new GlobalEnvironment());
        assertEquals(1, result);
    }

}
