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
 *
 * @see <a href="https://leetcode.com/problems/generate-parentheses/"></a>
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

    public List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        backtrack1(result, n, n, new StringBuilder());
        return result;
    }

    private void backtrack1(List<String> result, int open, int close, StringBuilder temp) {
        if (open == 0 && close == 0) {
            result.add(temp.toString());
            return;
        }
        if (open > 0) {
            backtrack1(result, open - 1, close, temp.append("("));
            temp.setLength(temp.length() - 1);
        }
        if (close > open) {
            backtrack1(result, open, close - 1, temp.append(")"));
            temp.setLength(temp.length() - 1);
        }
    }
}
