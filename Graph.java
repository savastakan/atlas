import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Graph {

    private final Map<Integer, Set<Integer>> nodes = new HashMap<>();
    private final Map<Integer,Edge> edges = new HashMap<>();
    private final Set<Integer> starts = new HashSet<>();
    private final Set<Integer> finishes = new HashSet<>();

    public void addVertex(int s)
    {
        nodes.put(s, new HashSet<>());
    }

    public void addEdge(int label, int source, int destination, int input, int output, int weight) {
        if (!nodes.containsKey(source))
            addVertex(source);
        if (!nodes.containsKey(destination))
            addVertex(destination);
        Edge edge = new Edge(label, source, destination, input, output, weight);
        nodes.get(source).add(label);
        edges.put(label, edge);

    }


    public Edge getEdge(Integer label){
        return edges.get(label);
    }
    public Set<Integer> getEdgeLabels(){
        return new HashSet<>(edges.keySet());
    }

    public Set<Integer> edgeLabels(int node){
        return nodes.get(node);
    }

    public Set<Integer> getStarts() {
        return starts;
    }
    public Set<Integer> getFinishes() {
        return finishes;
    }
    public void addStart(int root){
        starts.add(root);
    }
    public void addFinish(int root){
        finishes.add(root);
    }


    public Map<Integer, Set<Integer>> getNodes() {
        return nodes;
    }

    public Map<Integer, Edge> getEdges() {
        return edges;
    }
}