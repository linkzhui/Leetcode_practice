package Google.Array_String.Leetcode_683_K_Empty_Slots;

import java.util.TreeSet;

//time complexity: O(n log n)
//space complexity: O(n)
public class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        if(flowers == null || flowers.length == 0) {
            return -1;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < flowers.length; i++) {
            int element = flowers[i];
            set.add(element);
            Integer lower = set.lower(element);
            Integer higher = set.higher(element);
            if(lower != null && element - lower - 1 == k || higher != null && higher  - element -  1 == k) {
                return i + 1;
            }
        }
        return -1;
    }
}
