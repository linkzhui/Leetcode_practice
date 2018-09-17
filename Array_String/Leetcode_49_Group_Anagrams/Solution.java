package Google.Array_String.Leetcode_49_Group_Anagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        if(strs == null || strs.length == 0)
        {
            return result;
        }

        HashMap<String,List<String>> map = new HashMap<>();
        for(String element:strs)
        {
            int[] count = new int[26];
            for(Character str_char:element.toCharArray())
            {
                count[str_char-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            String prefix = "#";
            for(int i = 0;i<26;i++)
            {
                sb.append(prefix);
                sb.append(count[i]);
            }

            List<String> temp;
            String count_result = sb.toString();
            if(map.containsKey(count_result))
            {
                temp = map.get(count_result);
            }
            else{
                temp = new ArrayList<>();
            }
            temp.add(element);
            map.put(count_result,temp);
        }

        Iterator it = map.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry) it.next();
            result.add((List<String>) pair.getValue());
        }
        return result;
    }
}
