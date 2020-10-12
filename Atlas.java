import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Atlas {
    public void dfs(Graph graph, Edge edge, int[] cost, Stack<Edge> stack){
        cost[edge.getLabel()] = Integer.MIN_VALUE;
        for (int neighborEdgeLabel : graph.edgeLabels(edge.destination)){
            if (cost[neighborEdgeLabel] != Integer.MIN_VALUE){
                dfs(graph, graph.getEdge(neighborEdgeLabel), cost, stack);
            }
        }
        stack.add(edge);
    }

    public LinkedList<Integer>  longestPath(Graph graph, Integer start){
        LinkedList<Integer> path = new LinkedList<>();
        path.add(start);
        while (true){
            int currentStart = path.removeLast();
            Stack<Edge> stack = new Stack<>();
            int currentCost = Integer.MIN_VALUE;
            int[] cost = new int[graph.getEdges().size()];
            boolean[] visited = new boolean[graph.getEdges().size()];
            int current = Integer.MIN_VALUE;
            dfs(graph, graph.getEdge(currentStart), cost, stack);
            int[] comeFrom = cost.clone();
            cost[currentStart] = 0;

            while (!stack.isEmpty()){
                Edge edge = stack.pop();
                visited[edge.getLabel()] = true;
                for (int neighborEdgeLabel : graph.edgeLabels(edge.destination)){
                    if (!visited[neighborEdgeLabel]){
                        int new_cost = cost[edge.getLabel()] + (path.contains(neighborEdgeLabel) ? 0: 1);
                        if (cost[neighborEdgeLabel] < new_cost ){
                            cost[neighborEdgeLabel] = new_cost;
                            comeFrom[neighborEdgeLabel] = edge.getLabel();
                            if (currentCost < cost[neighborEdgeLabel]){
                                currentCost = cost[neighborEdgeLabel];
                                current = neighborEdgeLabel;
                            }
                        }
                    }
                }
            }
            if (cost[current] <= 0 ) {
                return path;
            }
            int size = path.size();
            path.add(current);
            while (comeFrom[current] >= 0){
                current = comeFrom[current];
                path.add(size,current);
            }
        }
    }
    void printPath(Graph graph,LinkedList<Integer> path){
        for(Integer edge: path){
            System.out.print(graph.getEdge(edge).source +"_"+ graph.getEdge(edge).destination +"_"+graph.getEdge(edge).input +" , ");
        }
        System.out.println();
    }

    public String getTestSuite(Graph graph, List<Integer> path){
        StringBuilder testCase = new StringBuilder();
        for (Integer edge : path){
            testCase.append(",").append(graph.getEdge(edge).input);
        }
        return testCase.substring(1);
    }


    public String run(Graph graph) {
        return getTestSuite(graph, longestPath(graph, graph.getStarts().iterator().next()));
    }
}

