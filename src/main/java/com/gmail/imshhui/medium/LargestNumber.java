package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * @see <a href="https://leetcode.com/problems/largest-number/"></a>
 * User: liyulin
 * Date: 2019/9/24
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((s1, s2) -> {
            String order1 = s1 + s2;
            String order2 = s2 + s1;
            return order2.compareTo(order1);
        });
        StringBuilder sb = new StringBuilder();
        list.forEach(s -> sb.append(s));
        if (sb.length() > 0 && sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    public String largestNumber1(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if ("0".equals(strings[0])) {
                return "0";
            }
            sb.append(strings[i]);
        }
        return sb.toString();
    }
}
