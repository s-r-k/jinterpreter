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
public class PlusOperator implements Operator {

    public Object operate(List<LispStatement> operands) {
        int result = 0;
        for (Iterator<LispStatement> iterator = operands.iterator(); iterator.hasNext();) {
            LispStatement operand = iterator.next();
            result = result + (Integer.valueOf((String) operand.eval())).intValue();
        }
        return String.valueOf(result);
    }
}
