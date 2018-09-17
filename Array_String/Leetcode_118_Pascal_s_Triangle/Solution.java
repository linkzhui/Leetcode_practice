package Google.Array_String.Leetcode_118_Pascal_s_Triangle;

import java.util.ArrayList;
import java.util.List;

//time complexity: O(num_row^2)
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for(int i = 1; i < numRows; i++) {
            List<Integer> levelResult = new ArrayList<>();
            List<Integer> prev = result.get(i-1);
            levelResult.add(1);
            for(int j = 1; j < i; j++) {
                levelResult.add(prev.get(j-1) + prev.get(j));
            }
            levelResult.add(1);
            result.add(levelResult);
        }
        return result;
    }
}
