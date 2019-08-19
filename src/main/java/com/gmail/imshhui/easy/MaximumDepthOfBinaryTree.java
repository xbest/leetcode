package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/"></a>
 * User: liyulin
 * Date: 2019/8/19
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int[] maxDepth = new int[1];
        levelHelper(root, maxDepth, 0);
        return maxDepth[0];
    }

    private void levelHelper(TreeNode root, int[] maxDepth, int depth) {
        if (root == null) {
            maxDepth[0] = Math.max(maxDepth[0], depth);
            return;
        }
        levelHelper(root.left, maxDepth, depth + 1);
        levelHelper(root.right, maxDepth, depth + 1);
    }
}
