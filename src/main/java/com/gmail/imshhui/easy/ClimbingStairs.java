package com.gmail.imshhui.easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * @see <a href="https://leetcode.com/problems/climbing-stairs/"></a>
 * User: liyulin
 * Date: 2019/7/29
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        return backtrace(n);
    }

    private int backtrace(int remain) {
        if (remain < 0) {
            return 0;
        }
        if (remain == 0) {
            return 1;
        }
        int n1 = backtrace(remain - 1);
        int n2 = backtrace(remain - 2);
        return n1 + n2;
    }

}
