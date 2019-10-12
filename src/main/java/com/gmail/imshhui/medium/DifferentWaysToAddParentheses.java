package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string of numbers and operators,
 * return all possible results from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 *
 * Example 1:
 *
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * @see <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">
 *     241. Different Ways to Add Parentheses</a>
 * User: liyulin
 * Date: 2019/10/12
 */
public class DifferentWaysToAddParentheses {
    private Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> list1 = diffWaysToCompute(part1);
                List<Integer> list2 = diffWaysToCompute(part2);
                for (Integer int1 : list1) {
                    for (Integer int2 : list2) {
                        int value = 0;
                        switch (c) {
                            case '+':
                                value = int1 + int2;
                                break;
                            case '-':
                                value = int1 - int2;
                                break;
                            case '*':
                                value = int1 * int2;
                                break;
                        }
                        res.add(value);
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }
        map.put(input, res);
        return res;
    }
}
