package Google.Recursion.Maze_Generator;

import java.util.HashSet;
import java.util.Random;

//Question: Given a N * N matrix, how to randomly generate a maze whose cooridor and wall's width are both 1 cell.
//In the meanwhile, for each each pair of cells on the corridor, there must exist a path between them.

//Solution:
//step 1: generate a n * n matrix with all 0
//step 2: random pick a start point, every time we move 2 steps （直直的走两步）， 为什么走两步是因为要确保墙和路之前的距离为1
//step 3: run dfs to go random direction to traverse the matrix

//space complexity: O(n^2)  n is the width or length of the matrix
//time complexity: O(n^2)
public class Solution {
    public static void main (String[] args) {
        Solution sol = new Solution();
        sol.mazeGenerator(20,15);
    }

    //4 direction to move
    int[] direction_x = {0,1,0,-1};
    int[] direvtion_y = {1,0,-1,0};

    public int[][] mazeGenerator(int length, int width) {
        if(length == 0 || width == 0) {
            return null;
        }

        //we will mark the unvisited as 0, road as 1
        int[][] visited = new int[length][width];
        Random r = new Random();
        int start_x = r.nextInt(length);
        int start_y = r.nextInt(width);
        dfs(visited, start_x, start_y);
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }
        return visited;
    }

    private void dfs(int[][] visited, int cur_x, int cur_y) {
        HashSet<Integer> set = new HashSet<>();
        Random r = new Random();
        while( set.size() < 4 ) {
            int move_direction = r.nextInt(4);
            if (set.add(move_direction)) {
                if(validMove(visited,cur_x,cur_y,move_direction)) {
                    dfs(visited,cur_x + 2 * direction_x[move_direction], cur_y + 2 * direvtion_y[move_direction]);
                }
            }
        }
    }

    private boolean validMove(int[][] visited, int cur_x, int cur_y, int move_direction) {
        for (int i = 0; i < 2; i++) {
            cur_x+=direction_x[move_direction];
            cur_y+=direvtion_y[move_direction];
            if (cur_x < 0 || cur_y < 0 || cur_x >= visited[0].length || cur_y >= visited.length || visited[cur_y][cur_x] == 1) {
                return false;
            }
        }
        //we can create a road in that move_direction
        for (int i = 0; i < 2; i++) {
            visited[cur_y][cur_x] = 1;
            cur_x+=direction_x[move_direction] * -1;
            cur_y+=direvtion_y[move_direction] * -1;
        }
        return true;
    }
}
