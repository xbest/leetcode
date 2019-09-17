package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * @see <a href="https://leetcode.com/problems/reorder-list/"></a>
 * User: liyulin
 * Date: 2019/9/17
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        // NullPointerException occurred in the wrong condition
        // while (p2 != null && p2.next != null) {
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode cur = p1.next;
        ListNode pre = p1;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = pre.next;
            pre.next = next;
        }
        ListNode firstHead = head;
        ListNode secondHead = p1.next;
        while (firstHead != p1) {
            p1.next = secondHead.next;
            secondHead.next = firstHead.next;
            firstHead.next = secondHead;
            firstHead = secondHead.next;
            secondHead = p1.next;
        }
    }
}
