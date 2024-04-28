package com.cc.algo.base.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/

//字母组合：多个字母无法依次展开for，递归从0～n-1，但是递归可以枚举到不确定的n-1，克服了顺序枚举的缺陷。
public class DFS_Enum {
    Map<Character, char[]> mapping;

    void initMapping() {
        mapping = new HashMap<>();
        mapping.put('2', new char[]{'a', 'b', 'c'});
        mapping.put('3', new char[]{'d', 'e', 'f'});
        mapping.put('4', new char[]{'g', 'h', 'i'});
        mapping.put('5', new char[]{'j', 'k', 'l'});
        mapping.put('6', new char[]{'m', 'n', 'o'});
        mapping.put('7', new char[]{'p', 'q', 'r', 's'});
        mapping.put('8', new char[]{'t', 'u', 'v'});
        mapping.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        initMapping();
        char[] keys = digits.toCharArray();
        int n = keys.length;
        dfs(0, keys);
        return res;
    }

    StringBuilder pick = new StringBuilder();

    // 从左往右枚举输入字符串的每一位，index 0 ~ n-1
    void dfs(int index, char[] keys) {
        if (index == keys.length) {
            if (pick.length() > 0) {
                res.add(new String(pick));
            }
            return;
        }
        //当前要做的事情是，找到mapping对应的可选字符数组，必定选中一个，然后跳转到下一个组内，然后回溯，依次循环选中
        char[] index_values = mapping.get(keys[index]);
        for (int j = 0; j < index_values.length; j++) {
            // 选中组内的一个
            pick.append(index_values[j]);
            // 跳到下一个组内
            dfs(index + 1, keys);
            // 恢复现场
            pick.deleteCharAt(index);
            // 进入j的循环，进行这个小组内，执行选中组内的下一个
        }
    }
}
