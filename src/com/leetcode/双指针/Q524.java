package com.leetcode.双指针;

import java.util.List;

public class Q524 {
    public String findLongestWord(String s, List<String> d) {
        String longWord = "";
        for (String str : d) {
            if (longWord.length() > str.length() || (longWord.length() == str.length() && longWord.compareTo(str) < 0))
                continue;
            if (isSubStr(s, str)) {
                longWord = str;
            }
        }
        return longWord;
    }

    private boolean isSubStr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
