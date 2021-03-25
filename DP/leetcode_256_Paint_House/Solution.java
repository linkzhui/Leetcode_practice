package Google.DP.leetcode_256_Paint_House;

public class Solution {
    public static void main(String[] args) {
        int[][] array = {{17,2,17},{16,16,5},{14,3,19}};
        Solution sol = new Solution();
        sol.minCost(array);
    }
    public int minCost(int[][] costs) {
        int[] colors = costs[0];
        for (int i = 1; i < costs.length; i++) {
            int[] new_colors = new int[costs[0].length];
            for (int j = 0; j < costs[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int z = 0; z < colors.length; z++) {
                    if (z!=j) {
                        min = Math.min(min, colors[z]);
                    }
                }
                new_colors[j] = min + costs[i][j];
            }
            colors = new_colors;
        }
        int min = colors[0];
        for (int i = 1; i < colors.length; i++) {
            min = Math.min(min, colors[i]);
        }
        return min;
    }
}
