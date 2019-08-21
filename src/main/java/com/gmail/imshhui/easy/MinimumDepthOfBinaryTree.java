package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 *
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/"></a>
 * User: liyulin
 * Date: 2019/8/21
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        return depthHelper(root);
    }

    private int depthHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depthHelper(root.left);
        int r = depthHelper(root.right);
        int min = Math.min(l, r);
        min = l == 0 ? r : min;
        min = r == 0 ? l : min;
        return min + 1;
    }
}
