package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 *
 * @see <a href="https://leetcode.com/problems/add-two-numbers-ii/">445. Add Two Numbers II</a>
 * User: liyulin
 * Date: 2019/11/29
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1 != null) {
            len1++;
            head1 = head1.next;
        }
        while (head2 != null) {
            len2++;
            head2 = head2.next;
        }
        head1 = l1;
        head2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        int difLen;
        if (len1 < len2) {
            difLen = len2 - len1;
            while (difLen-- > 0) {
                newHead.next = new ListNode(head2.val);
                newHead = newHead.next;
                head2 = head2.next;
            }
        } else if (len1 > len2) {
            difLen = len1 - len2;
            while (difLen-- > 0) {
                newHead.next = new ListNode(head1.val);
                newHead = newHead.next;
                head1 = head1.next;
            }
        }
        while (head1 != null && head2 != null) {
            newHead.next = new ListNode(head1.val + head2.val);
            newHead = newHead.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        int carry = valHelper(dummy.next);
        if (carry != 0) {
            ListNode temp = dummy.next;
            dummy.next = new ListNode(carry);
            dummy.next.next = temp;
        }
        return dummy.next;
    }

    private int valHelper(ListNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + valHelper(node.next);
        node.val = sum % 10;
        return sum / 10;
    }
}
