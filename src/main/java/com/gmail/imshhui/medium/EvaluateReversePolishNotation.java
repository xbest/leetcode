package com.gmail.imshhui.medium;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * @see <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/"></a>
 * User: liyulin
 * Date: 2019/9/18
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                // bad case ["4","13","5","/","+"]
                String op2 = stack.pop();
                String op1 = stack.pop();
                int value = doMath(op1, op2, token);
                stack.push(String.valueOf(value));
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private int doMath(String op1, String op2, String operator) {
        int oper1 = Integer.valueOf(op1);
        int oper2 = Integer.valueOf(op2);
        int value = 0;
        switch (operator) {
            case "+":
                value = oper1 + oper2;
                break;
            case "-":
                value = oper1 - oper2;
                break;
            case "*":
                value = oper1 * oper2;
                break;
            case "/":
                value = oper1 / oper2;
                break;
            default:
                break;
        }
        return value;
    }

}
