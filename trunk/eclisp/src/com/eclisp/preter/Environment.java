package com.eclisp.preter;

import com.eclisp.operator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * Environment
 */
public class Environment {
	private static Map operators = new HashMap();
	private static Map symbols = new HashMap();

	private static void initOperatorMap() {
		operators.put("+", new PlusOperator());
		operators.put("-", new MinusOperator());
		operators.put("*", new StarOperator());
		operators.put("/", new DivideOperator());

		operators.put("define", new DefineOperator());
		operators.put("cond", new ConditionalOperator());

		operators.put(">", new GreaterThanOperator());
		operators.put("<", new LesserThanOperator());
		operators.put("=", new EqualToOperator());

		operators.put("and", new AndOperator());
	}

	public static Operator getOperator(LispStatement key) {
		if (operators.isEmpty()) {
			initOperatorMap();
		}
		return (Operator) operators.get(key.toString());
	}

	public static void add(String operatorName, Operator o) {
		operators.put(operatorName, o);
	}

	public static Object getenv(String key) {
		return ((Stack) symbols.get(key)).peek();
	}

	public static void setenv(String key, Object value) {
		Stack values = (Stack) symbols.get(key);
		if (values == null)
			symbols.put(key, new Stack());
		((Stack) symbols.get(key)).push(value);
	}

	public static void unsetenv(String key) {
		Stack values = (Stack) symbols.get(key);
		values.pop();
		if (values.isEmpty())
			symbols.remove(key);
	}

	public static void dump() {
		System.out.println("operators = " + operators);
		System.out.println("symbols = " + symbols);
	}
}
