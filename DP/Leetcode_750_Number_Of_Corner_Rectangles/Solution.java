package Google.DP.Leetcode_750_Number_Of_Corner_Rectangles;

import java.util.HashMap;

public class Solution {


    //solution 1:
    //step1: we scan the matrix row by row, and we put every row[i] = 1, row[j] = 1 into the hashmap, for the rest row in the matrix,
    //if we find pair with same column index, we will know we find a Corner Rectangles
    //step2: we need HashMap to store all the pairs, and value to store how many pairs exist in the previous row.
    //step3: if we find a valid pair, we get the previous pair count, # 0f previous pair with current pair can form a corner rectangle.
    // we add # of previous pair into the result

    public int countCornerRectangles_1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        HashMap<String, Integer> pair_map = new HashMap<>();
        int result = 0;
        for (int[] row:grid) {
            for (int i = 0; i < row.length - 1; i++) {
                if (row[i] == 1) {
                    for (int j = i + 1; j < row.length; j++) {
                        if(row[j] == 1) {
                            String pair = i + " "+ j;
                            int count = pair_map.getOrDefault(pair, 0);
                            result += count;
                            pair_map.put(pair, ++count);
                        }
                    }
                }
            }
        }
        return result;
    }
}
