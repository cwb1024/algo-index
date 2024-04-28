package com.cc.algo.trie.smartSearch;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    String result;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
        this.result = null;
    }
}
