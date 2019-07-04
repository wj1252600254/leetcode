package com.leetcode.树.bst;

import com.TreeNode;

import java.util.Stack;

public class Q230 {
    //中序遍历
    public int kthSmallest(TreeNode root, int k) {
        int cnt = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (++cnt == k) {
                return node.val;
            }
            if (node.right != null) {
                cur = node.right;
            }
        }
        return 0;
    }
}
