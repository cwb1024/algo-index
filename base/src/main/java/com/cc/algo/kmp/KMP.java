package com.cc.algo.kmp;

public class KMP {
    public static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static int kmpSearch(String text, String pattern) {
        int[] next = getNext(pattern);
        int i = 0, j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) {
            return i - j; // 返回匹配的起始位置
        } else {
            return -1; // 未找到匹配的子串
        }
    }

    public static void main(String[] args) {
        String text = "ABABABABCABAAB";
        String pattern = "ABABCABAA";
        int index = kmpSearch(text, pattern);
        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}
