使用Trie树实现字符串匹配可以有效地提高匹配的速度，特别是在需要多次匹配相同模式串的情况下。

---
在这个示例中，
- 我们创建了一个 TrieStringMatcher 类来实现字符串匹配功能。
- TrieNode 类表示 Trie 树的节点，包含了孩子节点的映射和是否是单词结尾的标志。
- TrieStringMatcher 类实现了向Trie树中插入字符串和查找字符串是否存在的功能。

在 main 方法中，
- 我们创建了一个 TrieStringMatcher 对象，并向其中插入了一些字符串。
- 然后，我们调用 search 方法来查找特定字符串是否在Trie树中，并输出结果。