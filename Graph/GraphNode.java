package Google.Graph;

import java.util.List;

public class GraphNode {
    public int value;
    public List<GraphNode> neighboors;
    public GraphNode(int value, List<GraphNode> neighboors) {
        this.value = value;
        this.neighboors = neighboors;
    }
}
