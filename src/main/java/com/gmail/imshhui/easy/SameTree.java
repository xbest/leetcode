package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

import java.util.Stack;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 *
 * @see <a href="https://leetcode.com/problems/same-tree/"></a>
 * User: liyulin
 * Date: 2019/8/16
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        while (p != null && q != null || pStack.size() > 0 && qStack.size() > 0) {
            if (p != null && q == null
                    || p == null && q != null
                    || p != null && q != null && p.val != q.val) {
                return false;
            }
            if (p != null && q != null) {
                pStack.push(p);
                qStack.push(q);
                p = p.left;
                q = q.left;
            } else {
                p = pStack.pop();
                q = qStack.pop();
                p = p.right;
                q = q.right;
            }
        }
        return p == null && q == null;
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
}
