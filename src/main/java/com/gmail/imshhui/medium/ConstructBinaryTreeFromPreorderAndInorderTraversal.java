package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/"></a>
 * User: liyulin
 * Date: 2019/8/20
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rootHelper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode rootHelper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        while (i <= inEnd) {
            if (inorder[i] == root.val) {
                break;
            }
            i++;
        }
        root.left = rootHelper(preStart + 1, inStart, i - 1, preorder, inorder);
        // confused why i - inStart?
        root.right = rootHelper(preStart + i - inStart + 1, i + 1, inEnd, preorder, inorder);
        return root;
    }
}
