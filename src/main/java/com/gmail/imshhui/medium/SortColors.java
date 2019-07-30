package com.gmail.imshhui.medium;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 * @see <a href="https://leetcode.com/problems/sort-colors/"></a>
 * User: liyulin
 * Date: 2019/7/30
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zero > 0) {
                nums[i] = 0;
                zero--;
            } else if (one > 0) {
                nums[i] = 1;
                one--;
            } else if (two > 0) {
                nums[i] = 2;
                two--;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }
        int left = 0, current = 0, right = length - 1;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                current++;
                left++;
            } else if (nums[current] == 1) {
                current++;
            } else {
                swap(nums, right, current);
                right--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
