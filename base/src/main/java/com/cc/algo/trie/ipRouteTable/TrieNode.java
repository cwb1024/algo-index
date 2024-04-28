package com.cc.algo.trie.ipRouteTable;

import java.util.HashMap;
import java.util.Map;
public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    String route;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
        this.route = null;
    }
}
