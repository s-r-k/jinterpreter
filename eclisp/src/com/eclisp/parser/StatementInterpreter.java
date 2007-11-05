package com.eclisp.parser;

import com.eclisp.preter.LispStatement;
import com.eclisp.preter.CompoundLispStatement;

import java.util.Iterator;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: kramacha
 * Date: Mar 22, 2005
 * Time: 3:49:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class StatementInterpreter {

	public Object evaluate(LispStatement statement) {
		return statement.eval();
	}

	public Object evaluate(String statement) {
		List statements = new LispTokenBuilder(statement).buildStatements();
		Object result = null;
		for (Iterator iterator = statements.iterator(); iterator.hasNext();) {
			result = new CompoundLispStatement((String) iterator.next()).eval();
		}
		return result;
	}
}
