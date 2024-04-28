package com.cc.algo.trie.mem;

public class TrieMemoryManagement {
    private TrieNode root;

    public TrieMemoryManagement() {
        this.root = new TrieNode();
    }

    // 插入一个字符串到Trie树中
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    // 搜索一个字符串是否在Trie树中
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
        TrieMemoryManagement trie = new TrieMemoryManagement();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");

        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'orange': " + trie.search("orange")); // true
        System.out.println("Search 'grape': " + trie.search("grape")); // false
    }
}
