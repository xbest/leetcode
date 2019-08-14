package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/8/14
 */
public class ReverseLinkedListIITest {
    ReverseLinkedListII client = new ReverseLinkedListII();

    @Test
    public void reverseBetween() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        client.reverseBetween(head, 2, 4);
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(5);
        client.reverseBetween(head1, 1, 1);
    }
}
