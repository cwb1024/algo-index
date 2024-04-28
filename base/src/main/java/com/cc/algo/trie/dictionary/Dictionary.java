package com.cc.algo.trie.dictionary;

public class Dictionary {
    private TrieNode root;

    public Dictionary() {
        this.root = new TrieNode();
    }

    // 向字典中插入单词
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    // 判断一个单词是否在字典中
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false; // 字典中不存在该单词
            }
            current = current.children.get(ch);
        }
        return current.isEndOfWord; // 返回该单词是否为一个完整的单词
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.insert("apple");
        dictionary.insert("banana");
        dictionary.insert("orange");

        System.out.println("字典中是否包含单词 'apple': " + dictionary.search("apple")); // true
        System.out.println("字典中是否包含单词 'banana': " + dictionary.search("banana")); // true
        System.out.println("字典中是否包含单词 'grape': " + dictionary.search("grape")); // false
    }
}
