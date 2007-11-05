package com.eclisp.operator;

import com.eclisp.preter.PrimitiveLispStatement;
import com.eclisp.preter.LispStatement;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Apr 1, 2005
 * Time: 7:29:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class GreaterThanOperatorTest extends TestCase {
    private Operator greaterThanOperator;
    private List<LispStatement> operands;

    protected void setUp() throws Exception {
        greaterThanOperator = new GreaterThanOperator();
        operands = new ArrayList<LispStatement>();
        operands.add(new PrimitiveLispStatement("4"));
    }

    public void testGreaterThanReturnsTrueIfGreater() {
        operands.add(new PrimitiveLispStatement("3"));
        Boolean result = (Boolean) greaterThanOperator.operate(operands);
        assertEquals(Boolean.TRUE, result);
    }

    public void testGreaterThanReturnsFalseIfLesser() {
        operands.add(new PrimitiveLispStatement("5"));
        Boolean result = (Boolean) greaterThanOperator.operate(operands);
        assertEquals(Boolean.FALSE, result);
    }

    public void testGreaterThanReturnsFalseIfEqual() {
        operands.add(new PrimitiveLispStatement("4"));
        Boolean result = (Boolean) greaterThanOperator.operate(operands);
        assertEquals(Boolean.FALSE, result);
    }
}
