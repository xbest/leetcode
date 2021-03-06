package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 * <p>
 * User: liyulin
 * Date: 2019/7/9
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        ListNode currentHead = head;
        int x = length - n;
        if (x == 0) {
            currentHead = currentHead.next;
        }
        int i = 1;
        while (head != null) {
            if (i == x) {
                head.next = head.next == null ? null : head.next.next;
                break;
            }
            head = head.next;
            i++;
        }
        return currentHead;
    }

    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

}
