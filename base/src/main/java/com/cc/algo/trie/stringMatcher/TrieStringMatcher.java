package com.cc.algo.trie.stringMatcher;

public class TrieStringMatcher {
    private TrieNode root;

    public TrieStringMatcher() {
        this.root = new TrieNode();
    }

    // 向Trie树中插入字符串
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    // 查找字符串是否在Trie树中
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false; // 字符串不存在
            }
            current = current.children.get(ch);
        }
        return current.isEndOfWord; // 返回是否找到了字符串的结束节点
    }

    public static void main(String[] args) {
        TrieStringMatcher trieMatcher = new TrieStringMatcher();
        trieMatcher.insert("apple");
        trieMatcher.insert("banana");
        trieMatcher.insert("orange");

        System.out.println("Search 'apple': " + trieMatcher.search("apple")); // true
        System.out.println("Search 'orange': " + trieMatcher.search("orange")); // true
        System.out.println("Search 'grape': " + trieMatcher.search("grape")); // false
    }
}
