package Google.DP.Leetcode_403_Frog_Jump;

import java.util.HashMap;
import java.util.HashSet;

//DP solution
//time complexity: O(n^2)
//space complexity: O(n^2)

public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        //map key: the stone position, values: # of possible jump unit from previous stone to this stone position
        //step 1: put all the stone position into the hashmap
        //setp 2: traversal the whole array, for  for every possible jumpsize, we check if current stone position + jump_size is exist in the hashmap or not
        //step 3: if exist, we add jump unit into new stone jump position
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(Integer stone:stones) {
            map.put(stone, new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            HashSet<Integer> jump_count = map.get(stones[i]);
            for(Integer jump : jump_count) {
                for(int temp_jump = jump - 1; temp_jump<=jump+1; temp_jump++)
                {
                    if (temp_jump > 0 && map.containsKey(stones[i] + temp_jump)) {
                        map.get(stones[i]+temp_jump).add(temp_jump);
                    }
                }
            }
        }
        return map.get(stones[stones.length-1]).size() > 0;
    }
}
