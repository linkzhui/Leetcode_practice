package Google.Array_String.First_non_duplicated_element;


import java.util.HashMap;

//找到第一个没有重复的元素
public class Solution {

    //Solution 1: Use HashMap
    public Character first (String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (Character element : array) {
            Integer freq = map.getOrDefault(element, 0);
            map.put(element,freq+1);
        }
        for (Character element : array) {
            if (map.get(element) == 1) {
                return element;
            }
        }
        return null;
    }

    //Solution 2: Use Double Linked list
}
