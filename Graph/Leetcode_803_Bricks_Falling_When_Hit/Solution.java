package Google.Graph.Leetcode_803_Bricks_Falling_When_Hit;


//the key question is found out the bricks number that can connect to the top one by the hit one.
//so there have 3 kind of bricks:
//
//the hit one is zero, it can connect nothing to the top
//the hit one is 1, but it cannot connect to top, then no one can connect to top by it.
//the hit one is 1, it can connect to the top, but the near one can connect to the top by other bricks too;
//for this case when remove the hit one, the one connect to it will no drop
//the hit one is 1, it can connect to the top, and the near one can connect to the top by it and no other way connect to the top.
//for this case, there will be some brick drop after the hit one been removed.
//So what need to do is:
//1. check whether the hit one can connect to the top;
//2. count the bricks number that cannot connect to the top without the hit one.

//为什么要从hits从后面往前遍历，是因为，这样子就可以当所有的hits都删掉的时候，看看会掉多少，然后把这个点给补上，然后看第二个hits删掉的时候，会怎么样
public class Solution {
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] result = new int[hits.length];
        if (grid == null || grid.length == 0) {
            return result;
        }
        removeHits(grid, hits);
        for (int i = 0; i < grid.length; i++) {
            dfsSearch(grid, 0, i);
        }
        for (int i = hits.length - 1; i>=0; i--) {
            int row = hits[i][0];
            int col = hits[i][1];
            if (grid[row][col] == 0){
                grid[row][col] = 1;
                if (isConnected(grid, row, col)) {
                    result[i] = dfsSearch(grid, row, col) - 1;
                }
            }

        }
        return result;
    }

    private void removeHits(int[][] grid, int[][] hits) {
        for(int i = 0; i < hits.length; i++) {
            int row = hits[i][0];
            int col = hits[i][1];
            grid[row][col] = grid[row][col] - 1;
        }
    }

    private int dfsSearch(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 1) {
            return 0;
        }
        int count = 1;
        grid[row][col] = 2;  //set to 2 means current node is visted
        for (int i = 0; i < 4; i++) {
            count += dfsSearch(grid, row + dirs[i][0], col + dirs[i][1]);
        }
        return count;
    }

    private boolean isConnected (int[][] grid, int row, int col) {
        if (row == 0) {
            return true;
        }
        if (row - 1 >= 0 && grid[row-1][col] == 2) {
            return true;
        }
        else if (col- 1 >= 0 && grid[row][col-1] == 2) {
            return true;
        }
        else if (row + 1 < grid.length && grid[row+1][col] == 2) {
            return true;
        }
        else if (col + 1 < grid[row].length && grid[row][col+1] == 2) {
            return true;
        }
        return false;
    }
}
