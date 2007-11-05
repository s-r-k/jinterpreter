package com.eclisp.operator;

import com.eclisp.preter.LispStatement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kramacha
 * Date: Mar 22, 2005
 * Time: 4:06:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class StarOperator implements Operator {

    public Object operate(List<LispStatement> operands) {
        int result = 1;
        for (Iterator<LispStatement> iterator = operands.iterator(); iterator.hasNext();) {
            LispStatement operand = iterator.next();
            result = result * (Integer.valueOf((String) operand.eval())).intValue();
        }
        return String.valueOf(result);
    }
}
