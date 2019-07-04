package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() == 0)
            return list;
        dfs(s, new StringBuilder(), list, 0);
        return list;
    }

    private void dfs(String s, StringBuilder str, List<String> list, int k) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                list.add(str.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            //如果只有有个0是符合IP地址要求的
            //如果是第二轮，也就是说要切割两个数，第一个数为0，肯定不可以的
            if (i != 0 && s.charAt(0) == '0')
                break;
            String part = s.substring(0, i + 1);
            if (Integer.parseInt(part) <= 255) {
                if (str.length() != 0)
                    part = "." + part;
                str.append(part);
                //为啥不能用++k,++k是k自己变成2，k+1是传入k+1，k并没有改变
                //subString()并不会改变原s的长度
                dfs(s.substring(i + 1), str, list, k+1);
                str.delete(str.length() - part.length(), str.length());
            }
        }
    }
}
