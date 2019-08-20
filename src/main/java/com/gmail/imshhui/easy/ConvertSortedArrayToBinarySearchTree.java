package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.TreeNode;

/**
 *Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @see <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/"></a>
 * User: liyulin
 * Date: 2019/8/20
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return treeHelper(nums, 0, nums.length - 1);
    }

    private TreeNode treeHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // make sure plus one here
        int mid = start + (end - start + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = treeHelper(nums, start, mid - 1);
        root.right = treeHelper(nums, mid + 1, end);
        return root;
    }
}

