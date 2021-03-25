package Google.Graph.Leetcode_127_Word_Ladder;

import java.util.*;

public class Solution {
    //directional-BFS:  Preferred Solution
    //https://www.youtube.com/watch?v=vWPCm69MSfs
    //step 1: create two sets: begin_word_set and end_word_set, initial we put begin word into begin_word_set and end_word into end_word_set
    //step 2: while two set is not empty, we expand every single node from the smaller size set, then we put generated new word back back to the expanded set.
    //          2.1  if generated new word is from other set, then we know we have find the path, return path
    //          2.2  if generated word is found from the word list, then we put new word into the temp set and delete current word from the word list (一旦一个单词被generate 出来，从起点到这个单词的最短路径就知道了)
    //step 3: let temp_set = expanded_set

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> begin_set = new HashSet<>();
        HashSet<String> end_set = new HashSet<>();
        Set<String> dic = new HashSet<>();
        dic.addAll(wordList);
        begin_set.add(beginWord);
        end_set.add(endWord);
        if (!dic.remove(endWord)) {
            return 0;
        }
        int level = 0;
        while(!begin_set.isEmpty() && !end_set.isEmpty()) {
            if (begin_set.size() > end_set.size()) {
                //swap, always expand the smaller set first
                HashSet<String> temp = begin_set;
                begin_set = end_set;
                end_set = temp;
            }
            ++level;
            HashSet<String> temp = new HashSet<>();
            for(String s : begin_set) {
                char[] array = s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    char orig_ch = array[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        array[i] = ch;
                        String word = new String(array);
                        if (end_set.contains(word)) {
                            return level+1;
                        }
                        if (dic.contains(word)) {
                            temp.add(word);
                            dic.remove(word);
                        }
                    }
                    array[i] = orig_ch;
                }
            }
            begin_set = temp;
        }
        return 0;
    }


    //BFS: 一层一层扫描，找到endWord就是最短路径
    //每次从queue里面expand一个node，generate下一个可以走的word，然后把这个word从wordlist删除，删除的原因是：bfs扫描已经保证了这是最短的距离，从begin word走到当前的word,为了避免走重复的路，
    // （将来如果还可以走到这个word，也是距离更长的word）,就把这个word从wordlist里面删除
    public int ladderLength_bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            ++level;
            int size = queue.size();
            for(; size > 0; size--) {
                char[] char_array = queue.pollFirst().toCharArray();
                for (int i = 0; i < char_array.length; i++) {
                    char origin_char = char_array[i];
                    for (char char_element = 'a'; char_element <= 'z'; char_element++) {
                        char_array[i] = char_element;
                        String word = new String(char_array);
                        if(dict.contains(word)) {
                            if(word.equals(endWord)) {
                                return level + 1;
                            }
                            queue.offerLast(word);

                            //这里为什么可以从dict里面删除呢，是因为bfs是一层一层扫描的，所以碰到这个word之后，就可以确保这是从beginWord走到当前的word的最短路径
                            dict.remove(word);
                        }
                    }
                    char_array[i] = origin_char;
                }
            }
        }
        return 0;
    }
}
