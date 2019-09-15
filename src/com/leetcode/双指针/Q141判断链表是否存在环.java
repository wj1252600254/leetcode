package com.leetcode.双指针;

import com.ListNode;

public class Q141判断链表是否存在环 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head, p2 = head.next;
        while (p1 != null && p2 != null && p2.next != null) {
            if (p1 == p2)
                return true;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }
}
