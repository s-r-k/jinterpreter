package com.eclisp.operator;

import com.eclisp.preter.LispStatement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Mar 17, 2005
 * Time: 9:39:34 PM
 */
public class NewPlusOperator implements Operator {

    public Object operate(List<LispStatement> operands) {
		Class aClass = LispNumber.typeOf(operands.get(0).eval());
		LispNumber result = new LispNumber();
        for (Iterator<LispStatement> iterator = operands.iterator(); iterator.hasNext();) {
            LispStatement operand = iterator.next();
//            result = result + (Integer.valueOf((String) operand.eval())).intValue();
//			result = result.add()
//			Integer
        }
        return String.valueOf(result);
    }
}
