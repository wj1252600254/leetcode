package com.leetcode.链表;

import com.ListNode;

import java.util.Stack;

public class Q445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        Stack<Integer> s1 = buildStack(l1);
        Stack<Integer> s2 = buildStack(l2);
        ListNode head = new ListNode(-1);
        int curry = 0;
        while (curry == 1 || !s1.isEmpty() || !s2.isEmpty()) {
            int p1 = 0, p2 = 0, sum = 0;
            if (!s1.isEmpty())
                p1 = s1.pop();
            if (!s2.isEmpty())
                p2 = s2.pop();
            sum = curry + p1 + p2;
            curry = sum / 10;
            ListNode listNode = new ListNode(sum % 10);
            listNode.next = head.next;
            head.next = listNode;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        return stack;
    }
}
