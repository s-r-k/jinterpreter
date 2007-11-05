package com.eclisp.operator;

import com.eclisp.parser.LispStatementBuilder;
import com.eclisp.preter.Environment;
import com.eclisp.preter.LispStatement;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kramacha
 * Date: Mar 25, 2005
 * Time: 3:47:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefineOperator implements Operator {

	public Object operate(List<LispStatement> operands) {
		String operand1 = operands.get(0).toString();
		LispStatement operand2 = operands.get(1);
		if (operand1.indexOf("(") == -1)
			defineSymbol(operand1, operand2);
		else
			defineProcedure(operand1, operand2);
		return "null";
	}

	private void defineSymbol(String operand1, LispStatement operand2) {
		Environment.setenv(operand1, operand2.eval());
	}

	private void defineProcedure(String signature, final LispStatement body) {
		List sigTokens = new LispStatementBuilder().buildLispStatements(signature);
		Environment.add(sigTokens.remove(0).toString(), new CustomOperator(sigTokens, body));
	}
}
