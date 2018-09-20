package Google.Graph.Union_Find;

import Google.Graph.Graph;

import java.util.Arrays;

public class Solution {


    public int find(int[] parents, int i){
        if (parents[i] == -1) {
            return i;
        }
        return find(parents,parents[i]);
    }

    public void union (int[] parents, int x, int y) {
        int x_parent = find(parents, x);
        int y_parent = find(parents, y);
        parents[x_parent] = y_parent;
    }

    public int isCycle (Graph graph) {
        int[] partens = new int[graph.e];
        Arrays.fill(partens, -1);

        for (int i = 0 ; i < graph.e; i++) {
            int x = find(partens,graph.edge[i].src);
            int y = find(partens,graph.edge[i].dest);

            if (x == y) {
                //we find a circle
                return 1;
            }
            union(partens,x,y);
        }

        //no circle detect
        return 0;
    }

}
