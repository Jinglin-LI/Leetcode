/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/
// Reference: https://discuss.leetcode.com/topic/38674/clean-java-trie-solution-23ms

public class AddAndSearchWordDataStructureDesign {
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean flag = false;
	}
	TrieNode root = new TrieNode();
	public void addWord(String word) {
		TrieNode t1 = root;                             // 像树一样，node指向children
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (t1.children[c - 'a'] == null) {
				t1.children[c - 'a'] = new TrieNode();
			}
			t1 = t1.children[c - 'a'];
		}
		t1.flag = true;
	}
	public boolean search(String word) {
		return search(root, word);
	}
	private boolean search(TrieNode node, String word) {
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == '.') {
				for (TrieNode x : node.children) {
					if (x != null && search(x, word.substring(i + 1)))
						return true;
				}
				return false;
			}
			else {
				node = node.children[c - 'a'];                  // 也记得要将node指向children
				if (node == null) {
					return false;
				}
			}
		}
		return node.flag;
	}
}
