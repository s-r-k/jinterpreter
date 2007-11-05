package com.eclisp.operator;

import com.eclisp.preter.CompoundLispStatement;
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
public class AndOperatorTest extends TestCase {
	private Operator andOperator;
	private List<LispStatement> operands;

	protected void setUp() throws Exception {
		andOperator = new AndOperator();
		operands = new ArrayList<LispStatement>();
	}

	public void testAndReturnsFalseIfOneOperandIsFalse() {
		operands.add(new CompoundLispStatement("< 4 0"));
		operands.add(new CompoundLispStatement("= 5 5"));
		Boolean result = (Boolean) andOperator.operate(operands);
		assertEquals(Boolean.FALSE, result);
	}

	public void testEqualToReturnsFalseIfBothOperandsAreFalse() {
		operands.add(new CompoundLispStatement("> 4 0"));
		operands.add(new CompoundLispStatement("= 4 0"));
		Boolean result = (Boolean) andOperator.operate(operands);
		assertEquals(Boolean.FALSE, result);
	}

	public void testEqualToReturnsTrueIfBothOperandsAreTrue() {
		operands.add(new CompoundLispStatement("> 4 0"));
		operands.add(new CompoundLispStatement("= 4 4"));
		Boolean result = (Boolean) andOperator.operate(operands);
		assertEquals(Boolean.TRUE, result);
	}
}
