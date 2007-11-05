package com.eclisp.operator;

import com.eclisp.preter.LispClauseStatement;
import com.eclisp.preter.LispStatement;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Apr 5, 2005
 * Time: 6:00:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConditionalOperatorTest extends TestCase {
	private List<LispStatement> operands;

	protected void setUp() {
		operands = new ArrayList<LispStatement>();
		operands.add(new LispClauseStatement("((> 0 0) 6)"));
	}

	public void testConditionalOperator() {
		operands.add(new LispClauseStatement("((= 0 0) 0)"));
        Operator conditionalOperator = new ConditionalOperator();
        String result = (String) conditionalOperator.operate(operands);
        System.out.println("result = " + result);
    }

	public void testOperatorForNull() {
		Operator conditionalOperator = new ConditionalOperator();
		String result = (String) conditionalOperator.operate(operands);
		System.out.println("result = " + result);
	}

}
