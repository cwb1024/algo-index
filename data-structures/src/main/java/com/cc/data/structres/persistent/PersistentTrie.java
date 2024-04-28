package com.cc.data.structres.persistent;

import java.util.*;

public class PersistentTrie {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    static class VersionedTrieNode {
        TrieNode root;

        public VersionedTrieNode() {
            root = new TrieNode();
        }

        public VersionedTrieNode(TrieNode root) {
            this.root = root;
        }
    }

    VersionedTrieNode[] versions;

    public PersistentTrie() {
        versions = new VersionedTrieNode[1]; // 初始版本
        versions[0] = new VersionedTrieNode();
    }

    // 插入单词
    public void insert(String word) {
        TrieNode current = versions[versions.length - 1].root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                current.children.put(ch, new TrieNode());
            }
            current = current.children.get(ch);
        }
        current.isEnd = true;
    }

    // 查询单词是否存在
    public boolean search(String word, int version) {
        TrieNode current = versions[version].root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return current.isEnd;
    }

    // 创建新版本
    public void createNewVersion() {
        VersionedTrieNode newVersion = new VersionedTrieNode(copyTrie(versions[versions.length - 1].root));
        VersionedTrieNode[] newVersions = new VersionedTrieNode[versions.length + 1];
        System.arraycopy(versions, 0, newVersions, 0, versions.length);
        newVersions[versions.length] = newVersion;
        versions = newVersions;
    }

    // 复制 Trie 树
    private TrieNode copyTrie(TrieNode node) {
        TrieNode copy = new TrieNode();
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            copy.children.put(entry.getKey(), copyTrie(entry.getValue()));
        }
        copy.isEnd = node.isEnd;
        return copy;
    }

    public static void main(String[] args) {
        PersistentTrie trie = new PersistentTrie();
        trie.insert("apple");
        trie.insert("banana");

        // 第一个版本的查询
        System.out.println(trie.search("apple", 0)); // 输出：true

        // 创建新版本并插入新单词
        trie.createNewVersion();
        trie.insert("orange");

        // 第二个版本的查询
        System.out.println(trie.search("apple", 1)); // 输出：true
        System.out.println(trie.search("orange", 1)); // 输出：true
        System.out.println(trie.search("banana", 1)); // 输出：true
    }
}

