package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 *
 * User: liyulin
 * Date: 2019/10/31
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        // res[0]: denotes the maximum amount of money that can be robbed if root is not robbed
        // res[1]: denotes the maximum amount of money robbed if it is robbed
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robHelper(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
