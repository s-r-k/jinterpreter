package com.eclisp.operator;

import com.eclisp.operator.Operator;
import com.eclisp.preter.LispStatement;

import java.util.List;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Apr 7, 2005
 * Time: 6:52:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class AndOperator implements Operator{
	public Object operate(List<LispStatement> operands) {
		for (Iterator<LispStatement> iterator = operands.iterator(); iterator.hasNext();) {
			if(iterator.next().eval().equals(Boolean.FALSE))
				return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
}
