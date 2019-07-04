package com.leetcode.矩阵与数组;

import java.util.HashMap;
import java.util.Map;

public class Q697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            last.put(num, i);
            if (!first.containsKey(num)) {
                first.put(num, i);
            }
        }
        int max = 0;
        for (int t : nums) {
            int fre = cnt.get(t);
            max = Math.max(max, fre);
        }
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int c = cnt.get(nums[i]);
            if (c != max) {
                continue;
            }
            ans = Math.min(last.get(nums[i]) - first.get(nums[i]) + 1, ans);
        }
        return ans;
    }
}
