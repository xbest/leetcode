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

    public int climbStairs1(int n) {
        int[] visited = new int[n + 1];
        return backtrace1(n, visited);
    }

    private int backtrace1(int remain, int[] visited) {
        if (remain < 0) {
            return 0;
        }
        if (remain == 0) {
            return 1;
        }
        if (visited[remain] > 0) {
            return visited[remain];
        }
        int n1 = backtrace1(remain - 1, visited);
        int n2 = backtrace1(remain - 2, visited);
        int n = n1 + n2;
        visited[remain] = n;
        return n;
    }

    public int climbStairsDp(int n) {
        if (n == 1) {
            return 1;
        }
        int[] ret = new int[n];
        ret[0] = 1;
        ret[1] = 2;
        for (int i = 2; i < n; i++) {
            ret[i] = ret[i - 1] + ret[i - 2];
        }
        return ret[n - 1];
    }

}
