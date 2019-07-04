package com.leetcode.搜索.回溯;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        if (root == null)
            return list;
        dfs(root, list, value);
        return list;
    }

    private void dfs(TreeNode root, List<String> list, List<Integer> value) {
        if (root == null)
            return;
        value.add(root.val);
        if (root.left == null && root.right == null)
            list.add(buildPath(value));
        else {
            dfs(root.left, list, value);
            dfs(root.right, list, value);
        }
        value.remove(value.size() - 1);
    }

    private String buildPath(List<Integer> value) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < value.size(); i++) {
            if (i < value.size() - 1)
                stringBuilder.append(value.get(i)).append("->");
            else
                stringBuilder.append(value.get(i));
        }
        return stringBuilder.toString();
    }
}

