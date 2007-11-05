package com.eclisp.operator;

import com.eclisp.preter.LispStatement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kramacha
 * Date: Mar 22, 2005
 * Time: 4:06:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinusOperator implements Operator {

    public Object operate(List<LispStatement> operands) {
        Iterator<LispStatement> iterator =  operands.iterator();
		int result = (Integer.valueOf((String) iterator.next().eval())).intValue();
        while ( iterator.hasNext()) {
			result = result - (Integer.valueOf((String) iterator.next().eval())).intValue();
        }
        return String.valueOf(result);
    }
}
