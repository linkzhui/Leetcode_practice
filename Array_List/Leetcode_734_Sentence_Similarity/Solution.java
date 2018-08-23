package Google.Array_List.Leetcode_734_Sentence_Similarity;

import java.util.HashSet;
import java.util.Set;


//time complexity, O(N+P)  :N is size of the pairs, P is size of words1
//Space complexity, O(P), size of pairs
//把similar pairs里的word组成一个新的string，然后就直接compare


public class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null || words2 == null || words1.length != words2.length || pairs == null)
        {
            return false;
        }

        Set<String> set =  new HashSet<>();
        String prefix = "&";
        for(String[] element:pairs)
        {
            set.add(element[0]+prefix+element[1]);
        }

        for(int i = 0;i<words1.length;i++)
        {
            if(words1[i].equals(words2[i]) || set.contains(words1[i]+"&"+words2[i]) || set.contains(words2[i]+"&"+words1[i]))
            {
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
