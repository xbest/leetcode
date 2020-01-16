package com.gmail.imshhui.medium;

/**
 * You are given a circular array nums of positive and negative integers.
 * If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k),
 * move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element,
 * and the first element's previous element is the last element.
 *
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1.
 * Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.
 *
 *
 *
 * Example 1:
 *
 * Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
 * Example 2:
 *
 * Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1.
 * By definition the cycle's length must be greater than 1.
 * Example 3:
 *
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement,
 * but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
 *
 *
 * Note:
 *
 * -1000 ≤ nums[i] ≤ 1000
 * nums[i] ≠ 0
 * 1 ≤ nums.length ≤ 5000
 *
 *
 * Follow up:
 *
 * Could you solve it in O(n) time complexity and O(1) extra space complexity?
 *
 * @see <a href="https://leetcode.com/problems/circular-array-loop/">457. Circular Array Loop</a>
 * User: liyulin
 * Date: 2020/1/16
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            Integer slow = i;
            int dir = nums[i];
            Integer fast = next(nums, 0, i);
            while (slow != null && fast != null && slow != fast) {
                slow = next(nums, dir, slow);
                fast = next(nums, dir, next(nums, dir, fast));
            }
            if (slow != null && slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Integer next(int[] nums, int dir, Integer pos) {
        if (pos == null) {
            return null;
        }
        // change in direction
        if (dir * nums[pos] < 0) {
            return null;
        }
        Integer next = (pos + nums[pos]) % nums.length;
        // wrap negative
        if (next < 0) {
            next = next + nums.length;
        }
        // self-pointer
        if (next == pos) {
            return null;
        }
        return next;
    }
}
