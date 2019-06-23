package com.leetcode.链表;

import com.ListNode;

public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode listNode = head.next;
        head.next = deleteDuplicates(listNode);
        return head.val == head.next.val ? head.next : head;
    }
}
