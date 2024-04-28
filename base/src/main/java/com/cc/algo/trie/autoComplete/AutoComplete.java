package com.cc.algo.trie.autoComplete;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete {
    private TrieNode root;

    public AutoComplete() {
        this.root = new TrieNode();
    }

    // 插入一个单词到Trie树中
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    // 查找所有以给定前缀开头的单词
    public List<String> findWordsWithPrefix(String prefix) {
        List<String> words = new ArrayList<>();
        TrieNode node = findNodeWithPrefix(prefix);
        if (node != null) {
            findAllWords(node, prefix, words);
        }
        return words;
    }

    // 辅助方法：查找以给定前缀开头的节点
    private TrieNode findNodeWithPrefix(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return null; // 前缀不存在
            }
            current = current.children[index];
        }
        return current;
    }

    // 辅助方法：深度优先搜索以给定节点为根的所有单词
    private void findAllWords(TrieNode node, String prefix, List<String> words) {
        if (node.isEndOfWord) {
            words.add(prefix);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            TrieNode child = node.children[ch - 'a'];
            if (child != null) {
                findAllWords(child, prefix + ch, words);
            }
        }
    }

    public static void main(String[] args) {
        AutoComplete autoComplete = new AutoComplete();
        autoComplete.insert("apple");
        autoComplete.insert("app");
        autoComplete.insert("banana");
        autoComplete.insert("orange");

        List<String> predictions = autoComplete.findWordsWithPrefix("app");
        System.out.println("Predictions for 'app': " + predictions);
    }
}
