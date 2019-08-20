package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

/**
 *Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/"></a>
 * User: liyulin
 * Date: 2019/8/20
 */
public class BalancedBinaryTree {
    private boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        treeHelper(root);
        return balance;
    }

    private int treeHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = treeHelper(root.left);
        int r = treeHelper(root.right);
        if (Math.abs(l - r) > 1) {
            balance = false;
        }
        return Math.max(l, r) + 1;
    }
}
