package com.cc.algo.trie.prefixMatch;

import java.util.*;

public class PrefixMatching {
    private TrieNode root;

    public PrefixMatching() {
        this.root = new TrieNode();
    }

    // 插入单词
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    // 查找具有特定前缀的所有单词
    public List<String> searchPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode current = root;
        // 先找到前缀的最后一个字符所在的节点
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return result; // 前缀不存在，返回空列表
            }
            current = current.children.get(ch);
        }
        // 递归获取所有以该节点为根的子树的单词
        searchPrefixHelper(prefix, current, result);
        return result;
    }

    // 递归获取以指定节点为根的子树的所有单词
    private void searchPrefixHelper(String prefix, TrieNode node, List<String> result) {
        if (node.isEndOfWord) {
            result.add(prefix);
        }
        for (char ch : node.children.keySet()) {
            searchPrefixHelper(prefix + ch, node.children.get(ch), result);
        }
    }

    public static void main(String[] args) {
        PrefixMatching trie = new PrefixMatching();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("app");
        trie.insert("application");
        trie.insert("orange");

        List<String> result = trie.searchPrefix("app");
        System.out.println("以 'app' 为前缀的单词有：");
        for (String word : result) {
            System.out.println(word);
        }
    }
}
