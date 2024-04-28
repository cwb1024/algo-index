package com.cc.algo.ext;

/**
 *
 马拉车算法（Manacher's Algorithm）用于在线性时间内查找字符串中的最长回文子串。
 它利用了回文串的对称性质，避免了重复计算，从而实现了线性时间复杂度。
 */
public class ManacherAlgorithm {

    // 马拉车算法
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // 在每个字符和字符串之间插入特殊字符，处理奇偶长度的回文串
        StringBuilder modifiedString = new StringBuilder();
        modifiedString.append("#");
        for (int i = 0; i < s.length(); i++) {
            modifiedString.append(s.charAt(i));
            modifiedString.append("#");
        }

        int center = 0; // 当前最长回文串的中心位置
        int maxRight = 0; // 当前最长回文串的右边界
        int maxLen = 0; // 最长回文串的长度
        int[] palindromeLengths = new int[modifiedString.length()]; // 记录以每个字符为中心的回文串的长度

        for (int i = 0; i < modifiedString.length(); i++) {
            // 判断当前字符是否在最长回文串的右边界内
            if (i < maxRight) {
                // 利用对称性质
                int mirror = 2 * center - i;
                palindromeLengths[i] = Math.min(maxRight - i, palindromeLengths[mirror]);
            }

            // 尝试扩展当前字符为中心的回文串的长度
            int left = i - (palindromeLengths[i] + 1);
            int right = i + (palindromeLengths[i] + 1);
            while (left >= 0 && right < modifiedString.length() && modifiedString.charAt(left) == modifiedString.charAt(right)) {
                palindromeLengths[i]++;
                left--;
                right++;
            }

            // 更新最长回文串的中心位置和右边界
            if (i + palindromeLengths[i] > maxRight) {
                center = i;
                maxRight = i + palindromeLengths[i];
            }

            // 更新最长回文串的长度
            if (palindromeLengths[i] > maxLen) {
                maxLen = palindromeLengths[i];
                center = i;
            }
        }

        // 截取最长回文串
        int start = (center - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Longest palindrome: " + longestPalindrome(s)); // "bab" or "aba" are both valid
    }
}
