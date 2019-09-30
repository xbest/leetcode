package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.ListNode;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/"></a>
 * User: liyulin
 * Date: 2019/9/27
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode temp = head.next;
        head.next = null;
        ListNode pre = dummyNode;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            temp = next;
        }
        return dummyNode.next;
    }

    /**
     * another iterative solution
     * @param head
     * @return
     */
    public ListNode reverseListIterative(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
