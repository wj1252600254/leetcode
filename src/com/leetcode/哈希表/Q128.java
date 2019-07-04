package com.leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;

public class Q128 {
    /**
     * 要求时间复杂度为O(n)
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : nums) {
            map.put(t, 1);
        }
        for (int t : nums) {
            forword(map, t);
        }
        return getMax(map);
    }

    private int forword(Map<Integer, Integer> hashMap, int num) {
        if (!hashMap.containsKey(num)) {
            return 0;
        }
        int cnt = hashMap.get(num);
        if (cnt > 1)
            return cnt;
        cnt = forword(hashMap, num + 1) + 1;
        hashMap.put(num, cnt);
        return cnt;
    }

    private int getMax(Map<Integer, Integer> hashMap) {
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        return max;
    }
}
