package com.eclisp.preter;

import com.eclisp.parser.LispStatementBuilder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Mar 17, 2005
 * Time: 9:21:44 PM
 */
public class CompoundLispStatement implements LispStatement {
	protected String statement;
	private List<LispStatement> operands;
	private LispStatement operator;

	public CompoundLispStatement(String statement) {
		this.statement = statement;
	}

	private void buildOperatorAndOperands() {
		List<LispStatement> tokensList = new LispStatementBuilder().buildLispStatements(statement);
		operands = new ArrayList<LispStatement>();
		operator = tokensList.remove(0);
		for(LispStatement statement:tokensList){
			operands.add(statement);
		}
	}

	public Object eval() {
		buildOperatorAndOperands();
		return Environment.getOperator(operator).operate(operands);
	}

	public String toString() {
		return statement;
	}
}
