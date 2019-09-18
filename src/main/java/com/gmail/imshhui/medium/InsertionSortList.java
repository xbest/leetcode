package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;

/**
 * Sort a linked list using insertion sort.
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * @see <a href="https://leetcode.com/problems/insertion-sort-list/"></a>
 * User: liyulin
 * Date: 2019/9/18
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode cur = head.next;
        dummyNode.next = new ListNode(head.val);
        while (cur != null) {
            ListNode next = cur.next;
            ListNode pre = dummyNode;
            ListNode newHead = dummyNode.next;
            while (newHead != null) {
                if (cur.val < newHead.val) {
                    pre.next = cur;
                    cur.next = newHead;
                    break;
                }
                pre = pre.next;
                newHead = newHead.next;
            }
            // 到达新list末尾也没有插入成功，则添加到尾部
            if (newHead == null) {
                pre.next = cur;
                // bad case [-1,5,3,4,0]
                cur.next = null;
            }
            cur = next;
        }
        return dummyNode.next;
    }

    public ListNode insertionSortList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummyNode;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummyNode;
            cur = next;
        }

        return dummyNode.next;
    }
}
