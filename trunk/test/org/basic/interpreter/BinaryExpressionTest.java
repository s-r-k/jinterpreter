package org.basic.interpreter;

import junit.framework.TestCase;


public class BinaryExpressionTest extends TestCase {

    public void testBodyFormation() {
        RuntimeEnvironment env = new RuntimeEnvironment();
        BinaryExpression expr = new BinaryExpression("val_1", "val_2", ArithmeticOperator.ADDITION, env);

    }

}
