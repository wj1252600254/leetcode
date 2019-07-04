package com.leetcode.树.bfs;

import com.TreeNode;

import java.util.LinkedList;

public class Q513 {
    //可以将roor指针移到最左子节点
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        int res = root.val;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            while (size-- > 0) {
                TreeNode treeNode = linkedList.pop();
                res = treeNode.val;
                if (treeNode.right != null) {
                    linkedList.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    linkedList.add(treeNode.left);
                }
            }
        }
        return res;
    }
}
