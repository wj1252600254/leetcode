package com.leetcode.链表;

import com.ListNode;

public class Q206 {
    //头结点法
    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode(0);
        //如果是head.next==null,那么输出为null,注意判断边界条件
        while (head != null) {
            ListNode next = head.next;
            head.next = p.next;
            p.next = head;
            head = next;
        }

        return p.next;
    }

    public ListNode dfs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode ext = head.next;
        ListNode p = dfs(head.next);
        ext.next = head;
        head.next = null;
        return p;
    }
}
