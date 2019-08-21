package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * @see <a href="https://leetcode.com/problems/path-sum/"></a>
 * User: liyulin
 * Date: 2019/8/21
 */
public class PathSum {
    private boolean result = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        pathHelper(root, 0, sum);
        return result;
    }

    private void pathHelper(TreeNode root, int path, int sum) {
        if (root == null) {
            return;
        }
        path = path + root.val;
        if (path == sum && root.left == null && root.right == null) {
            result = true;
            return;
        }
        pathHelper(root.left, path, sum);
        pathHelper(root.right, path, sum);
    }
}
