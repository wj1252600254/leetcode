package com.leetcode.矩阵与数组;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q565 {
    public int arrayNesting(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        int max = 0;
        for (int value : nums) {
            int num = value;
            int cnt = 0;
            while (!set.contains(num)) {
                set.add(num);
                num = nums[num];
                cnt++;
                if (num >= len) {
                    break;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

}
