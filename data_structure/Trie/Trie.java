package Google.data_structure.Trie;

public class Trie {
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode('a');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null && word.length() == 0) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.childrens[word.charAt(i)-'a'];
            if (next == null) {
                next = new TrieNode(word.charAt(i));
                cur.childrens[word.charAt(i)-'a'] = next;
            }
            cur = next;
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null && word.length() == 0) {
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.childrens[word.charAt(i)-'a'];
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = cur.childrens[prefix.charAt(i)-'a'];
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return true;
    }

    class TrieNode{
        TrieNode[] childrens = new TrieNode[26];
        boolean isWord = false;
        Character element;
        public TrieNode(Character element) {
            this.element = element;
        }
    }
}
