package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/"></a>
 * User: liyulin
 * Date: 2019/8/15
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.size() > 0) {
            if (root != null &&
                    (root.left != null && getMaxOfBST(root.left) >= root.val
                            || root.right != null && getMinOfBST(root.right) <= root.val)) {
                return false;
            }
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return true;
    }

    private int getMinOfBST(TreeNode root) {
        int min = root.val;
        while (root != null) {
            min = root.val < min ? root.val : min;
            root = root.left;
        }
        return min;
    }

    private int getMaxOfBST(TreeNode root) {
        int max = root.val;
        while (root != null) {
            max = root.val > max ? root.val : max;
            root = root.right;
        }
        return max;
    }

    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inorderList = new ArrayList<>();
        while (root != null || stack.size() > 0) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                inorderList.add(root.val);
                root = root.right;
            }
        }
        for (int i = 0; i < inorderList.size() - 1; i++) {
            if (inorderList.get(i) >= inorderList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
