package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * @see <a href="https://leetcode.com/problems/diameter-of-binary-tree/">543. Diameter of Binary Tree</a>
 * User: liyulin
 * Date: 2020/2/27
 */
public class DiameterOfBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDeepth(root);
        return max;
    }

    private int maxDeepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDeepth(root.left);
        int right = maxDeepth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
