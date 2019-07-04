package com.leetcode.位运算;

public class Q260 {
    public int[] singleNumber(int[] nums) {
        int ret = 0;
        int[] ans = new int[2];
        for (int n : nums) {
            ret = ret ^ n;
        }
        //ret为不为0的第一位
        ret &= (-ret);
        for (int n : nums) {
            if ((ret & n) == 0) {
                ans[0] ^= n;
            }else
                ans[1] ^= n;
        }
        return ans;
    }
}
