package Google.Line.find_all_anagram_of_a_substring;

import java.util.*;

public class Solution {
    public static void main(String[] args)
    {
        List<String> result;
        Solution sol = new Solution();
        String s1 = "aaaaabcdefg";
        String s2 = "acbd";
        result = sol.solution(s1,s2);
        System.out.println(Arrays.toString(result.toArray()));
    }
    public List<String> solution(String s1, String s2) {
        List<String> result = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i)) == false) {
                map.put(s2.charAt(i), 1);
            } else {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) + 1);
            }
        }

        Iterator it = map.entrySet().iterator();
        int count = map.size();
        /*
        for (int i = 0; i < int_array.length; i++) {
            if (map.containsKey(s1.charAt(i)) != false && map.get(s1.charAt(i)) > 0) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
                if (map.get(s1.charAt(i)) == 0) {
                    count--;
                }
            }

            if (count == 0) {
                result.add(s1.substring(0, int_array.length));
            }
        }
        */
        int length = 0;
        for (int i = 0; i < s1.length(); i++)
        {
            if (length==map.size() && map.containsKey(s1.charAt(i-map.size())) != false) {
                if (map.get(s1.charAt(i-map.size())) == 0) {
                    count++;
                }
                map.put(s1.charAt(i-map.size()), map.get(s1.charAt(i-map.size())) + 1);

            }

            if (map.containsKey(s1.charAt(i)) != false) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) - 1);
                if (map.get(s1.charAt(i)) == 0) {
                    count--;
                }
                if(length<map.size())
                {
                    length++;
                }

            }
            if (count == 0) {
                result.add(s1.substring(i-map.size()+1,i+1));
            }

        }
        return result;
    }

}
