/*
Implement a trie with insert, search, and startsWith methods.
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/
// design. Recursive. string 中从第二个char开始都是前一个Char的孩子(第一个字母存在TrieNode[] 中), 成为一种linked(可以有很多的连接线，连成一个词)。
// 每一个TrieNode有孩子和标记（元素长度为零并且插入则为真）。

class TrieNode {
    TrieNode[] children;
    boolean flag;
    
    public TrieNode() {
        children = new TrieNode[26];
        flag = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

                                                                // Inserts a word into the trie.
    public void insert(String word) {
        insert(root, word);
    }
    
    private void insert(TrieNode p, String word) {
        if (word.length() == 0) {                               // flag, have the element "null" 
            p.flag = true;  
            return;
        }
        char c = word.charAt(0);
        if (p.children[c - 'a'] == null) {
            TrieNode node = new TrieNode();
            p.children[c - 'a'] = node;
        }
        insert(p.children[c - 'a'], word.substring(1));         // recursive, substring(int beginIndex)
    }

                                                                // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null)
            return false;
        return search(root, word);
    }
    
    private boolean search(TrieNode p, String word) {
        if (word.length() == 0) {
            if (p.flag)
                return true;
            else 
                return false;
        }
        char c = word.charAt(0);
        if (p.children[c - 'a'] == null)
            return false;
        else 
            return search(p.children[c - 'a'], word.substring(1));
    }

                                                                // Returns if there is any word in the trie
                                                                // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null)
            return false;
        return startsWith(root, prefix);
    }
    
    private boolean startsWith(TrieNode p, String prefix) {
        if (prefix.length() == 0)
            return true;
        char c = prefix.charAt(0);
        if (p.children[c - 'a'] == null)
            return false;
        else
            return startsWith(p.children[c - 'a'], prefix.substring(1));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
