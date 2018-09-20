package Google.Graph;

public class Graph {
    public int v,e;  // v: vertices, e: edges
    public Edge edge[];  //collection of all edges
    public Graph (int v, int e) {
        this.v = v;
        this.e = e;
        for(int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }
    public static class Edge{
        public int src, dest;
    }
}
