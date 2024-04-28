package com.cc.algo.trie.autoComplete;

public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26]; // 假设只包含小写字母
        this.isEndOfWord = false;
    }
}
