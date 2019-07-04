package com.leetcode.树.bst;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q653 {
    //此方法错在，两个节点在两侧的情况没考虑到
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        int val = k - root.val;
        return dfs(root.left, val) || dfs(root.right, val) || findTarget(root.left, k) || findTarget(root.right, k);
    }

    private boolean dfs(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == k) {
            return true;
        }
        return dfs(root.left, k) || dfs(root.right, k);
    }

    /**
     * 双指针
     */
    public boolean f(TreeNode root, int k) {
        List<Integer> integers = gene(root, new ArrayList<>());
        int i = 0, j = integers.size()- 1;
        while (i < j) {
            int sum = integers.get(i) + integers.get(j);
            if (sum == k)
                return true;
            else if (sum < k)
                i++;
            else
                j--;
        }
        return false;
    }

    //递归了解一下
    private List<Integer> gene(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return list;
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
}
