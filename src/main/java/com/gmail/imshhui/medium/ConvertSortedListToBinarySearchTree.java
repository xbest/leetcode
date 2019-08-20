package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;
import com.gmail.imshhui.bean.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @see <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/"></a>
 * User: liyulin
 * Date: 2019/8/20
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return treeHelper(head, null);
    }

    private TreeNode treeHelper(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = treeHelper(head, slow);
        root.right = treeHelper(slow.next, tail);
        return root;
    }
}
