package com.leetcode.贪心思想;

import java.util.Arrays;

public class Q452投飞镖刺破气球 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
        int count = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= pre)
                continue;
            count++;
            pre = points[i][1];
        }
        return count;
    }
}
