package com.leetcode.数学;

public class Q204 {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] booleans = new boolean[n];
        //看清题意
        for (int i = 2; i < n; i++) {
            if (booleans[i])
                continue;
            count++;
            //如果是long j=i*i，那么i*i可能会发生数据溢出
            for (long j = (long) i * i; j < n; j += i) {
                booleans[(int) j] = true;
            }
        }
        return count;
    }
}
