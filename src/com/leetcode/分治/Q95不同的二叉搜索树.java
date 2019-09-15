package com.leetcode.分治;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q95不同的二叉搜索树 {
    /**
     * 分治递归
     * 如何构建自己想要的递归函数
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        return df(1, n);
    }

    private List<TreeNode> df(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = df(start, i - 1);
            List<TreeNode> right = df(i + 1, end);
            for (TreeNode le : left) {
                for (TreeNode ri : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = le;
                    treeNode.right = ri;
                    list.add(treeNode);
                }
            }
        }
        return list;

    }
}
