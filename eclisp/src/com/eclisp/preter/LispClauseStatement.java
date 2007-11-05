package com.eclisp.preter;

import com.eclisp.parser.LispStatementBuilder;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Apr 5, 2005
 * Time: 7:41:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class LispClauseStatement implements LispStatement {
	private LispStatement predicate;
	private LispStatement expression;

	public LispClauseStatement(String statement) {
		List<LispStatement> operands = new LispStatementBuilder().buildLispStatements(statement);
		predicate = operands.get(0);
		expression = operands.get(1);

	}

	public Object eval() {
		if (predicate.eval().equals(Boolean.TRUE))
			return expression.eval();
		return null;
	}

}
