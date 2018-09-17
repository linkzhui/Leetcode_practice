package Google.DP.Leetcode_120_Triangle;

import java.util.List;

//dp solution: bottom up DP solution
//dp equation: dp[k][i] = Math.min(dp[k-1][i], dp[k-1][i+1]) + triangle[k][i];  k is row, i is column
//dp[k][i] represent: the min path sum from left level to current node
//because dp[k][] is only depend on the dp[k-1][], therefore we can convert the 2D dp array to 1D array -> dp[i] = Math.min(dp[i],dp[i+1]) + triangle[k][i];

//space complexity: O(n) n is the depth of the triangle
//time complexity: O(n) n is num of element from triangle
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] levelPath = new int[row];
        if(row == 1) {
            return triangle.get(0).get(0);
        }
        int index = 0;
        for(Integer element:triangle.get(row-1)) {
            levelPath[index++] = element;
        }
        for(int i = row - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                levelPath[j] = Math.min(levelPath[j],levelPath[j+1]) + triangle.get(i).get(j);
            }
        }
        return levelPath[0];
    }
}
