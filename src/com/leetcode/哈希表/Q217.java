package com.leetcode.哈希表;

import java.util.HashSet;
import java.util.Set;

public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int c : nums) {
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }
}
