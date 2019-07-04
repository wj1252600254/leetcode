package com.leetcode.树.bst;

import com.ListNode;
import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode preMid(ListNode root) {
        ListNode pre = root, slow = root, fast = root.next;
        while (fast != null && fast.next != null) {
            //如果直接返回slow，则取不到前一个节点了
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
