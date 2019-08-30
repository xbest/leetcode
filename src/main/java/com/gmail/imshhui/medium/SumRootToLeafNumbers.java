package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 * @see <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/"></a>
 * User: liyulin
 * Date: 2019/8/30
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int[] sum = {0};
        treeHelper(root, "", sum);
        return sum[0];
    }

    private void treeHelper(TreeNode root, String pre, int[] sum) {
        if (root == null) {
            return;
        }
        if (root != null && root.left == null && root.right == null) {
            sum[0] += Integer.valueOf(pre + root.val);
            return;
        }
        treeHelper(root.left, pre + root.val, sum);
        treeHelper(root.right, pre + root.val, sum);
    }
}

