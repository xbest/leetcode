package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/"></a>
 * User: liyulin
 * Date: 2019/8/5
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                // skip the value-equaled node
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
