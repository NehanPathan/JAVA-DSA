public class App {
    public static void main(String[] args) throws Exception {
        var graph = new WeightedGraph();

        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");

        graph.addEdge("a", "b", 1);
        graph.addEdge("b", "c", 2);
        graph.addEdge("a", "c", 10);

        var path = graph.getShortestPath("a", "c");

        System.out.println(path);
    }
}
