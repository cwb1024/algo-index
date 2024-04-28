package com.cc.algo.trie.statisticsSort;

import java.util.*;
public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    int count;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
        this.count = 0;
    }
}
