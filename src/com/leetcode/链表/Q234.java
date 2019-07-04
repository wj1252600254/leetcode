package com.leetcode.链表;

import com.ListNode;

public class Q234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;
        cut(head, slow);
        ListNode re = reverse(slow);
        return isValid(head, re);
    }

    private void cut(ListNode head, ListNode node) {
        while (head.next != node) {
            head = head.next;
        }
        head.next = null;
    }

    /**
     *     ListNode newHead = null;
     *     while (head != null) {
     *         ListNode nextNode = head.next;
     *         head.next = newHead;
     *         newHead = head;
     *         head = nextNode;
     *     }
     *     return newHead;
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode fir = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = fir.next;
            fir.next = head;
            head = next;
        }
        return fir.next;
    }

    private boolean isValid(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
