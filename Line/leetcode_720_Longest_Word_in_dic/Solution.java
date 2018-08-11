package Google.Line.leetcode_720_Longest_Word_in_dic;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args)
    {
        String[] words = {"w","wo","wor","worl","world"};
        Solution sol = new Solution();
        System.out.print(sol.longestWord(words));
    }

    public String longestWord(String[] words)
    {
        Trie trie = new Trie(words);
        int index = 0;
        for(String word:words)
        {
            //这里提前加是为了区别，有没有word在这里end，
            // 如果有word在这里end的话，index就不为0
            //没有的话，index为0
            trie.insert(word,++index);
        }
        return trie.dfs();
    }

    class TrieNode{
        char c;
        int index; //index of the this string in string array
        HashMap<Character, TrieNode> children = new HashMap<>();
        public TrieNode(char c){
            this.c = c;
        }
    }

    class Trie{
        TrieNode root;
        String[] words;
        public Trie(String[] words){
            root = new TrieNode(' ');
            this.words = words;
        }

        public void insert(String word, int index){
            TrieNode cur = root;

            for(int i = 0 ;i<word.length();i++)
            {
                char c = word.charAt(i);

                if(cur.children.containsKey(c))
                {
                    cur = cur.children.get(c);
                }
                else {
                    TrieNode new_element = new TrieNode(c);
                    cur.children.put(c, new_element);
                    cur = new_element;
                }
            }
            cur.index = index;
        }

        public String dfs(){
            String ans = "";
            ArrayDeque<TrieNode> stack = new ArrayDeque<>();
            stack.push(root);
            while(!stack.isEmpty())
            {
                TrieNode cur = stack.pop();
                if(cur.index>0||cur==root)
                {
                    if(cur!=root)
                    {
                        //如果不是root的话，就可以对比word 和 ans
                        String word = words[cur.index-1];
                        if(word.length()>ans.length() || (word.length() == ans.length()&&word.compareTo(ans)<0))
                        {
                            ans = word;
                        }
                    }
                    for(TrieNode element:cur.children.values())
                    {
                        stack.offer(element);
                    }
                }
            }
            return ans;
        }
    }
}
