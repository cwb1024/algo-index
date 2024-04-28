package com.cc.algo.trie.statisticsSort;

import java.util.*;

public class WordStatisticsAndSorting {
    private TrieNode root;

    public WordStatisticsAndSorting() {
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
        current.count++;
    }

    // 获取所有单词
    public List<String> getAllWords() {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        getAllWordsHelper(root, sb, result);
        return result;
    }

    // 递归遍历 Trie 树获取所有单词
    private void getAllWordsHelper(TrieNode node, StringBuilder sb, List<String> result) {
        if (node.isEndOfWord) {
            result.add(sb.toString());
        }
        for (char ch : node.children.keySet()) {
            sb.append(ch);
            getAllWordsHelper(node.children.get(ch), sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        WordStatisticsAndSorting wordCounter = new WordStatisticsAndSorting();
        wordCounter.insert("apple");
        wordCounter.insert("banana");
        wordCounter.insert("apple");
        wordCounter.insert("orange");
        wordCounter.insert("banana");
        wordCounter.insert("apple");
        wordCounter.insert("orange");

        List<String> allWords = wordCounter.getAllWords();
        Collections.sort(allWords); // 对单词进行排序

        System.out.println("单词统计和排序结果：");
        for (String word : allWords) {
            System.out.println(word + ": " + wordCounter.getWordCount(word) + " 次");
        }
    }

    // 获取单词出现次数
    public int getWordCount(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return 0; // 单词不存在
            }
            current = current.children.get(ch);
        }
        return current.count;
    }
}
