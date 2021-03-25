package Google.Array_String.Leetcode_904_Fruit_Into_Baskets;

import java.util.HashMap;

public class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        int count = 0;
        for (int i = 0; i < tree.length; i++) {
            int freq = map.getOrDefault(tree[i],0);
            map.put(tree[i], freq + 1);
            while (map.size() > 2) {
                map.put(tree[start], map.get(tree[start])-1);
                if (map.get(tree[start]) == 0) {
                    map.remove(tree[start]);
                }
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
