package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 * @see <a href="https://leetcode.com/problems/sum-of-left-leaves/">404. Sum of Left Leaves</a>
 * User: liyulin
 * Date: 2019/11/14
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res = res + root.left.val;
            } else {
                res = res + sumOfLeftLeaves(root.left);
            }
        }
        res = res + sumOfLeftLeaves(root.right);
        return res;
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return treeHelper(root, false);
    }

    private int treeHelper(TreeNode root, boolean isLeft) {
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        return treeHelper(root.left, true) + treeHelper(root.right, false);
    }
}
