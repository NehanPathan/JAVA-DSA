
public class App {
    public static void main(String[] args) throws Exception {
        var garph = new Graph();

        garph.addNode("x");
        garph.addNode("a");
        garph.addNode("b");
        garph.addNode("d");
        garph.addNode("e");
        garph.addNode("p");

        garph.addEdge("x", "a");
        garph.addEdge("x", "b");
        garph.addEdge("a", "d");
        garph.addEdge("b", "e");
        garph.addEdge("d", "p");
        garph.addEdge("e", "p");

        System.out.println(garph.topologicalSort("x"));

    }
}
