package com.gmail.imshhui.medium;

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 * @see <a href="https://leetcode.com/problems/add-and-search-word-data-structure-design/"></a>
 * User: liyulin
 * Date: 2019/9/30
 */
public class WordDictionary {
    private Trie trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        boolean ans = false;
        if (word.contains(".")) {
            // TODO
        }
        return false;
    }

    private class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    private class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                while (node != null) {
                    if (!node.containsKey(c)) {
                        node.put(c, new TrieNode());
                    }
                    node = node.get(c);
                }
            }
            node.setEnd();
        }

        public TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length() && node != null; i++) {
                char c = prefix.charAt(i);
                if (node.containsKey(c)) {
                    node = node.get(c);
                } else {
                    node = null;
                }
            }
            return node;
        }

        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */