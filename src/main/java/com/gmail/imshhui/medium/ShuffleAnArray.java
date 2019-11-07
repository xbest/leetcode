package com.gmail.imshhui.medium;

import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 *
 * @see <a href="https://leetcode.com/problems/shuffle-an-array/">384. Shuffle an Array</a>
 * User: liyulin
 * Date: 2019/11/7
 */
public class ShuffleAnArray {
    private int[] nums;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffleNums = nums.clone();
        for (int i = shuffleNums.length; i > 1; i--) {
            swap(shuffleNums, i - 1, random.nextInt(i));
        }
        return shuffleNums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
