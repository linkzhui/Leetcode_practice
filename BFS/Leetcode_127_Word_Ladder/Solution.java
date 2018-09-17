package Google.BFS.Leetcode_127_Word_Ladder;


//BFS: level by level search,
// 1. at each level, we will check if we only change characters from original string, do we find a matched word from the wordList
// 2. if we find a matched word, we will put that word into the queue.

// in order to avoid to generate visited word, we need a hashset to put visited word into set
// also we need a queue, in order to search the word level by level.

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0 || beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || beginWord.equals(endWord)) {
            return 0;
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> dic = new HashSet<>();
        for(String element : wordList) {
            dic.add(element);
        }
        int level = 1;
        queue.offerLast(beginWord);
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.pollFirst();
                char[] charArray = word.toCharArray();
                for(int j = 0; j < word.length(); j++) {
                    char origin = charArray[j];
                    for(char a = 'a'; a <= 'z'; a++) {
                        charArray[j] = a;
                        String newWord = new String(charArray);
                        if(dic.contains(newWord) && !visited.contains(newWord)) {
                            if(newWord.equals(endWord)) {
                                return level + 1;
                            }
                            queue.addLast(newWord);
                            visited.add(newWord);
                        }
                    }
                    charArray[j] = origin;
                }
            }
            level++;
        }
        return 0;
    }
}
