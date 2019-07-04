package com.leetcode.图;

import java.util.Arrays;

public class Q785 {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !isBi(i, 0, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBi(int node, int color, int[] colors, int[][] graph) {
        if (colors[node] != -1) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int t : graph[node]) {
            if (!isBi(t, 1 - color, colors, graph)) {
                return false;
            }
        }
        return true;
    }
}
