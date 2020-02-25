package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Given a binary search tree with non-negative values,
 * find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 *
 * Note: There are at least two nodes in this BST.
 *
 * @see <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/">530. Minimum Absolute Difference in BST</a>
 * User: liyulin
 * Date: 2020/2/25
 */
public class MinimumAbsoluteDifferenceInBST {
    private int min = Integer.MAX_VALUE;
    private TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        treeHelper(root);
        return min;
    }

    private void treeHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        treeHelper(root.left);

        if (pre != null) {
            min = Math.min(min, Math.abs(root.val - pre.val));
        }
        pre = root;
        treeHelper(root.right);
    }
}
