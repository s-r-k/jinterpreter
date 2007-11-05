package com.eclisp.operator;

import com.eclisp.preter.LispStatement;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Mar 17, 2005
 * Time: 9:17:31 PM
 */
public interface Operator {
    public Object operate(List<LispStatement> operands);

}
