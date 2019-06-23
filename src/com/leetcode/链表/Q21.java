package com.leetcode.链表;

import com.ListNode;

public class Q21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fir = new ListNode(-1);
        ListNode p = fir;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                p.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        return fir.next;
    }
}
