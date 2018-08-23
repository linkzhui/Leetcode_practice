package Google.Recursion.Leetcode_737_Sentence_Similarity_II;

import java.util.*;

public class Solution {
    public boolean areSentencesSimilarTwo_1(String[] words1, String[] words2, String[][] pairs)
    {
        //Solution_1: Depth-First Search
        //Time Complex: O(NP)  N is number of words from string[], P is length of pairs
        //Space Complex: O(P) P is the length of pairs

        if(words1.length != words2.length)
        {
            return false;
        }
        Map<String, List<String>> graph = new HashMap<>();
        for(String[] pair:pairs)
        {
            for(String element:pair)
            {
                if(!graph.containsKey(element))
                {
                    graph.put(element,new ArrayList<>());
                }
            }
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

        for(int i = 0;i<words1.length;i++)
        {
            //this element already been checked or already in the stack, avoid the loop
            Set<String> seen = new HashSet<>();
            Deque<String> stack = new ArrayDeque<>();
            String word1 = words1[i];
            String word2 = words2[i];
            stack.addLast(word1);
            seen.add(word1);
            search: {
                while (!stack.isEmpty()) {
                    String word = stack.poll();
                    if (word.equals(word2)) break search;
                    if (graph.containsKey(word)) {
                        for (String nei: graph.get(word)) {
                            if (!seen.contains(nei)) {
                                stack.push(nei);
                                seen.add(nei);
                            }
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}
