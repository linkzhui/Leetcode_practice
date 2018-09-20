package Google.Graph.Clone_Graph;

import Google.Graph.GraphNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    //Use map to store whether a node has been copied before
    //For every single recursion function call, we make a copy of the input node, and leave all other copies of the
    //the successors to the recursion functions

    public GraphNode cloneGraph_DFS (GraphNode input, HashMap<GraphNode, GraphNode> lookup) {
        //base case
        if (input == null) {
            return null;
        }
        if (lookup.containsKey(input)) {
            return lookup.get(input);
        }
        GraphNode copyNode = new GraphNode(input.value, new ArrayList<>());
        lookup.put(input, copyNode);
        for (GraphNode neighboor : input.neighboors) {
            copyNode.neighboors.add(cloneGraph_DFS(neighboor,lookup));
        }
        return copyNode;
    }
    public GraphNode cloneGraph_BFS (GraphNode input, HashMap<GraphNode, GraphNode> lookup) {
        if (input == null) {
            return null;
        }
        ArrayDeque<GraphNode> queue = new ArrayDeque<>();
        HashMap<GraphNode, GraphNode> map = new HashMap<>();
        GraphNode newHead = new GraphNode(input.value, new ArrayList<>());
        map.put(input,newHead);
        queue.offerLast(input);

        while (!queue.isEmpty()) {
            GraphNode node = queue.pollFirst();
            GraphNode copied_node = map.get(node);
            for (GraphNode neighboor : node.neighboors) {
                if (neighboor != null && !map.containsKey(neighboor)) {
                    map.put(neighboor,new GraphNode(neighboor.value, new ArrayList<>()));
                    queue.offerLast(neighboor);
                }
                copied_node.neighboors.add(map.get(neighboor));
            }
        }
        return map.get(input);
    }
}
