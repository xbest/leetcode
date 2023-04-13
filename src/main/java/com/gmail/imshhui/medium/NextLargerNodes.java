package com.gmail.imshhui.medium;

import com.gmail.imshhui.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1019. 链表中的下一个更大节点
 * 给定一个长度为n的链表head
 *
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 *
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置answer[i] = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-node-in-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * https://leetcode.cn/problems/next-greater-node-in-linked-list/
 *
 * @Author liyulin
 * @Date 2023/4/13 14:57
 * @Version 1.0
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }
        int[] res = new int[nodes.size()];
        for (int i = 0; i < res.length; i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(j) > nodes.get(i)) {
                    res[i] = nodes.get(j);
                    break;
                }
            }
        }
        return res;
    }
}
