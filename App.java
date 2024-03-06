
public class App {
    public static void main(String[] args) throws Exception {
        var garph = new WeightedGraph();

        garph.addNode("a");
        garph.addNode("b");
        garph.addNode("c");

        garph.addEdge("a", "b", 3);
        garph.addEdge("a", "c", 2);

        garph.print();
    }
}
