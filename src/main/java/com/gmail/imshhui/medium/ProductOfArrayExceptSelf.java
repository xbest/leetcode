package com.gmail.imshhui.medium;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">238. Product of Array Except Self</a>
 * User: liyulin
 * Date: 2019/10/12
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = right[length - 1] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] output = new int[length];
        for (int i = 0; i < output.length; i++) {
            output[i] = left[i] * right[i];
        }
        return output;
    }

    public int[] productExceptSelfOneArray(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        ans[0] = 1;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = right * ans[i];
            right = right * nums[i];
        }
        return ans;
    }
}
