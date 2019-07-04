package com.leetcode.树.bfs;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q637 {
    public static void main(String[] args) {
        double a = 0.0;
        System.out.println(a);
        a += 1;
        System.out.println(a);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            double ave = 0.0;
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                ave += node.val;
                if (node.left != null) {
                    linkedList.add(node.left);
                }
                if (node.right != null) {
                    linkedList.add(node.right);
                }
            }
            list.add(ave / size);
        }
        return list;
    }
}
