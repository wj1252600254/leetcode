package com.leetcode.数学;

public class Q367 {
    //可以用二分法
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        int mid = num / 2;
        for (int i = mid; i > 0; i--) {
            if (i * i == num)
                return true;
        }
        return false;
    }


    public boolean m2(int num) {
        int diff = 3;
        int fir = 1;
        while (fir < num) {
            fir += diff;
            diff += 2;
        }
        return fir == num;
    }
}
