package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 * @see <a href="https://leetcode.com/problems/rotate-list/"></a>
 * User: liyulin
 * Date: 2019/7/25
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        if (length == k) {
            return head;
        }
        int step = length - k % length;
        ListNode cur = head;
        ListNode ret;
        while (step > 1) {
            cur = cur.next;
            step--;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }
}
