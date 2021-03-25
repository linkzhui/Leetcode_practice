package Google.BFS.leetcode_317_Shortest_Distance_from_all_buildings;

import java.util.ArrayDeque;

public class Solution {

    public static void main(String[] args) {

    }
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[][] count = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    dijistra(grid, count, i, j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(grid[i][j], min);
                }
            }
        }
        return min;
    }

    private void dijistra(int[][] grid, int[][] count, int row, int col) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int steps = 0;
        queue.offerLast(new int[]{row,col});
        int length = grid.length;
        int col_len = grid[0].length;
        int[][] visited = new int[length][col_len];
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coord = queue.pollFirst();
                int current_row = coord[0];
                int current_col = coord[1];
                for (int[] dir : dirs) {
                    int new_row = current_row + dir[0];
                    int new_col = current_col + dir[1];
                    if (new_row >= 0 && new_row < length && new_col >= 0 && new_col < col_len && visited[new_row][new_col] != 1 && grid[new_row][new_col] == 0) {
                        //current land is not visited before and it is a empty land
                        visited[new_row][new_col] = 1;
                        count[new_row][new_col] += steps;
                        queue.offerLast(new int[]{new_row, new_col});
                    }
                }
            }

        }
    }
}
