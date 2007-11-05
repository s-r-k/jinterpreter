package com.eclisp.operator;

import com.eclisp.preter.LispStatement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Apr 5, 2005
 * Time: 6:03:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConditionalOperator implements Operator {

	public Object operate(List<LispStatement> operands) {
		for (Iterator<LispStatement> iterator = operands.iterator(); iterator.hasNext();) {
			Object result = iterator.next().eval();
			if (result != null)
				return result;
		}
		return "null";
	}
}
