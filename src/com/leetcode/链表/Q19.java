package com.leetcode.链表;

import com.ListNode;

public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        while (n-- > 0) {
            p2 = p2.next;
        }
        //if p2==null,it means that the head node should be deleted
        if (p2 == null)
            return head.next;
        else {
            while (p2.next != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            p1.next = p1.next.next;
            return head;
        }
    }
}
