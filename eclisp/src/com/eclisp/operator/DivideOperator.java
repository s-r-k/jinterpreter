package com.eclisp.operator;

import com.eclisp.preter.LispStatement;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kramacha
 * Date: Mar 22, 2005
 * Time: 4:06:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class DivideOperator implements Operator {
    public Object operate(List<LispStatement> operands) {
        int operand1Value = (Integer.valueOf((String) (operands.get(0)).eval())).intValue();
        int operand2Value = (Integer.valueOf((String) (operands.get(1)).eval())).intValue();

		int result = new Integer(operand1Value / operand2Value).intValue();
		return String.valueOf(result);
	}
}
