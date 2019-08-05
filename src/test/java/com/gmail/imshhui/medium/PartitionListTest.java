package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/8/5
 */
public class PartitionListTest {
    PartitionList client = new PartitionList();

    @Test
    public void partitionList() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        client.partition(head, 3);
    }
}
