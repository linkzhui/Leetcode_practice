package Google.Graph.Leetcode_547_Friend_Circles;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    //DFS: time complexity: O(n^2)
    //     space complexity: O(n)  -> int[] visited
    public int findCircleNum_dfs(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0 || M.length != M [0].length ) {
            return 0;
        }
        //int[] visited: keep tracking every visited person, if this person is already visited
        // we will keep recursive
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if(visited[i] == 0) {
                //unvisited
                dfs(M,visited,i);
                count++;
            }
        }
        return count;
    }

    private void dfs (int[][] M, int[] visited, int index) {
        for (int i = 0; i < M.length; i++) {
            if (M[index][i] == 1 && visited[i] == 0 && index!= i) {
                visited[i] = -1;
                dfs (M, visited, i);
            }
        }
    }


    //BFS: time complexity O(n^2)
    //     space complexity O(n)
    public int findCircleNum_bfs(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.offerLast(i);
                count++;
                while (!queue.isEmpty()) {
                    int index = queue.pollFirst();
                    visited[index] = -1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[index][j] == 1 && visited[j] ==0 && index != j) {
                            queue.offerLast(j);
                        }
                    }
                }
            }
        }
        return count;
    }


    //Union find: time complexity: O(n^3)
    //            space complexity: O(n)
    public int findCircleNum_union_find (int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (Integer element : parent) {
            if (element == -1){
                //if element == -1, means this is the parent of this set
                count++;
            }
        }
        return count;
    }

    private int find (int[] parent, int i) {
        if(parent[i] == -1) {
            return i;
        }
        return find(parent,parent[i]);
    }

    private void union (int[] parent, int i, int j) {
        int i_parent = find(parent, i);
        int j_parent = find(parent, j);
        if (i_parent != j_parent){
            parent[i_parent] = j_parent;
        }
    }

}
