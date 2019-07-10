package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * User: liyulin
 * Date: 2019/7/9
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, n, n, "");
        return result;
    }

    private void backtrack(List<String> result, int open, int close, String temp) {
        if (open == 0 && close == 0) {
            result.add(temp);
            return;
        }
        if (open > 0) {
            backtrack(result, open - 1, close, temp + "(");
        }
        if (close > open) {
            backtrack(result, open, close - 1, temp + ")");
        }
    }
}
