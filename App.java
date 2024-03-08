public class App {
    public static void main(String[] args) throws Exception {
        var graph = new WeightedGraph();

        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");

        graph.addEdge("a", "b", 0);
        graph.addEdge("b", "c", 0);
        // graph.addEdge("a", "c", 0);

        System.out.println(graph.hasCycle());
    }
}
