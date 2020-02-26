package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 *
 * @see <a href="https://leetcode.com/problems/convert-bst-to-greater-tree/"></a>
 * User: liyulin
 * Date: 2020/2/26
 */
public class ConvertBSTToGreaterTree {
    private int sum;

    public TreeNode convertBST(TreeNode root) {
        treeHelper(root);
        return root;
    }

    private void treeHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        treeHelper(root.right);
        root.val = root.val + sum;
        sum = root.val;
        treeHelper(root.left);
    }
}
