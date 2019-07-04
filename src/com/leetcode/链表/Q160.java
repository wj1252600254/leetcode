package com.leetcode.链表;

import com.ListNode;

public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode seconde = headB;
        while (first != seconde) {
            if (first == null) {
                first = headB;
            } else
                first = first.next;
            if (seconde == null) {
                seconde = headA;
            } else
                seconde = seconde.next;
        }
        return first;
    }
}
