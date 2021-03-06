package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * Follow-up:
 * Can you solve it without using extra space?
 *
 * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii/"></a>
 * User: liyulin
 * Date: 2019/9/17
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        while (head != null) {
            if (isBeginCycle(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    private boolean isBeginCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        boolean isHead = false;
        int step = 0;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            step++;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = head.next;
        while (temp != null && step >= 0) {
            if (temp == head) {
                isHead = true;
            }
            step--;
            temp = temp.next;
        }
        return true && isHead;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode first = head;
                while (first != slow) {
                    first = first.next;
                    slow = slow.next;
                }
                return first;
            }
        }
        return null;
    }

    public ListNode detectCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head;
        while (first != slow) {
            first = first.next;
            slow = slow.next;
        }
        return first;
    }
}
