
public class App {
    public static void main(String[] args) throws Exception {
        var garph = new Graph();

        garph.addNode("a");
        garph.addNode("b");
        garph.addNode("c");

        garph.addEdge("a", "b");
        garph.addEdge("b", "c");
        garph.addEdge("c", "a");

        System.out.println(garph.hasCycle());
    }
}
