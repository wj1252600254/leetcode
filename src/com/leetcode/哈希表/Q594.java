package com.leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Q594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : nums) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        int len = 0;
        for (Integer m : map.keySet()) {
            //1 1 1 1
//            len = Math.max(len, map.get(m) + map.getOrDefault(m + 1, 0));
            if (map.containsKey(m + 1)) {
                len = Math.max(len, map.get(m) + map.get(m + 1));
            }
        }
        return len;
    }
}
