package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->         ->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/"></a>
 * User: liyulin
 * Date: 2019/8/13
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode slow = dummy;
        int i = 1;
        ListNode reverseTail = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (i == m) {
                reverseTail = cur;
            }
            // bad case: [3,5], m=1, n=2, if add curNext != null condition
            // if (i >= m && i <= n && curNext != null) {
            if (i >= m && i <= n) {
                // bad case: [3,5], m=1, n=1, if below code is here
                // reverseTail.next = curNext;
                cur.next = slow.next;
                slow.next = cur;
                reverseTail.next = curNext;
            } else {
                slow = slow.next;
            }
            cur = curNext;
            i++;
        }
        return dummy.next;
    }
}
