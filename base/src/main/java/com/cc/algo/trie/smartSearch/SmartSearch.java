package com.cc.algo.trie.smartSearch;

public class SmartSearch {
    private TrieNode root;

    public SmartSearch() {
        this.root = new TrieNode();
    }

    // 插入关键词和对应的结果
    public void insert(String keyword, String result) {
        TrieNode current = root;
        for (char ch : keyword.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
        current.result = result;
    }

    // 搜索关键词
    public String search(String keyword) {
        TrieNode current = root;
        for (char ch : keyword.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return null; // 没有找到匹配的关键词
            }
            current = current.children.get(ch);
        }
        if (!current.isEndOfWord) {
            return null; // 没有找到完整匹配的关键词
        }
        return current.result; // 返回匹配的结果
    }

    public static void main(String[] args) {
        SmartSearch searchEngine = new SmartSearch();
        searchEngine.insert("ha", "哈工大");
        searchEngine.insert("he", "哈尔滨");
        searchEngine.insert("s", "深圳");
        searchEngine.insert("sh", "上海");

        System.out.println("Searching for 'ha': " + searchEngine.search("ha"));
        System.out.println("Searching for 'he': " + searchEngine.search("he"));
        System.out.println("Searching for 's': " + searchEngine.search("s"));
        System.out.println("Searching for 'sh': " + searchEngine.search("sh"));
        System.out.println("Searching for 'hello': " + searchEngine.search("hello"));
    }
}
