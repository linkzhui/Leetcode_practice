package Google.Array_String.Leetcode_290_Word_Pattern;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }

        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char key = pattern.charAt(i);
            String word = map.get(key);
            if (word == null) {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(key,words[i]);
            } else if(!word.equals(words[i])) {
                    return false;
            }
        }
        return true;
    }
}
