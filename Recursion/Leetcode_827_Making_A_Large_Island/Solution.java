package Google.Recursion.Leetcode_827_Making_A_Large_Island;

public class Solution {
    public static void main(String[] args) {
        int[][] array = {{1,0},{0,1}};
        Solution sol = new Solution();
        System.out.print(sol.largestIsland_1(array));
    }



    //dfs: traver整个array，把每一个看到的0都转换成1，然后查找有多少个相连的1
    //time complexity: O(n^4)
    //space complexity: O(n^2)
    public int largestIsland_1(int[][] grid) {
        if (grid == null || (grid.length == 0 && grid[0].length == 0)) {
            return 0;
        }
        int[] max = new int[1];
        boolean one = false;

        //看到一个0，就把这个0转换成1，然后做dfs找出有多少个相邻的1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    one = true;
                    grid[i][j] = 1;
                    max[0] = Math.max(max[0],helper(grid, visited, i, j, max));
                    grid[i][j] = 0;
                }
            }
        }

        //要确保一个0都没有的情况
        return !one? grid.length * grid.length : max[0];
    }

    private int helper (int[][] grid, boolean[][] visited, int row, int column, int[] max) {
        if(row < 0 || row == grid.length || column < 0 || column == grid[0].length || grid[row][column] == 0 || visited[row][column]) {
            return 0;
        }
        visited[row][column] = true;
        int cur_max = 0;
        cur_max += helper(grid, visited, row + 1, column, max);
        cur_max += helper(grid, visited, row, column + 1, max);
        cur_max += helper(grid, visited, row -1, column, max);
        cur_max += helper(grid, visited, row, column - 1, max);
        cur_max++;
        return cur_max;
    }
}
