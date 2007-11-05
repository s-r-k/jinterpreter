package com.eclisp.operator;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Jun 1, 2005
 * Time: 9:04:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class LispNumber {

	public LispNumber() {

	}

	public <T extends Number>  Class<T>  getAnnotation(Class<T> something){
		return something;

	}

	public static Class typeOf(Object o) {
		return Integer.class;
	}
}
