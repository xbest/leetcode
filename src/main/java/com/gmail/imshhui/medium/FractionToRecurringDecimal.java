package com.gmail.imshhui.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 *
 * @see <a href="https://leetcode.com/problems/fraction-to-recurring-decimal/"></a>
 * User: liyulin
 * Date: 2019/9/23
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        // bad case 0, 3
        if (numerator == 0) {
            return "0";
        }
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //bad case -1, -2147483648. long cast is required
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        // sign part
        sb.append((numerator ^ denominator) < 0 ? "-" : "");

        // integral part
        sb.append(n / d);

        long remainder = n % d;
        if (remainder == 0) {
            return sb.toString();
        }

        //fractional part
        sb.append(".");
        map.put(remainder, sb.length());
        while (remainder != 0) {
            remainder = remainder * 10;
            sb.append(remainder / d);
            remainder = remainder % d;
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(").append(")");
                break;
            } else {
                map.put(remainder, sb.length());
            }
        }
        return sb.toString();
    }
}
