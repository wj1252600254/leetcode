package com.leetcode.树.bst;

import com.TreeNode;

public class Q538 {
    int sum = 0;

    //很写出的过程的题目，不放想一下递归，简单无脑
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    private void convert(TreeNode root) {
        if (root == null)
            return;
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
    }
}
