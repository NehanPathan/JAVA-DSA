public class App {
    public static void main(String[] args) throws Exception {
        var graph = new WeightedGraph();

        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");

        graph.addEdge("a", "b", 3);
        graph.addEdge("b", "d", 4);
        graph.addEdge("c", "d", 5);
        graph.addEdge("a", "c", 1);
        graph.addEdge("b", "c", 2);

        var tree = graph.getMinimumSpanningTree();
        tree.print();
    }
}
