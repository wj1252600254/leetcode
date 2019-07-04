package com.leetcode.树.bst;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q501 {
    TreeNode pre = null;
    int max = 1;
    int cnt = 1;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int size = list.size();
        int[] res = new int[size];
        for (Integer t : list) {
            res[--size] = t;
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        if (pre != null && pre.val == root.val) {
            cnt++;
        } else if (pre != null)
            cnt = 1;
        if (cnt > max) {
            max = cnt;
            list.clear();
            list.add(root.val);
        } else if (cnt == max)
            list.add(root.val);
        pre = root;
        dfs(root.right, list);
    }
}
