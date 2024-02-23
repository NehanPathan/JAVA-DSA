
public class App {
    public static void main(String[] args) throws Exception {
     var garph = new Graph();

        garph.addNode("a");
        garph.addNode("b");
        garph.addNode("c");
        garph.addNode("d");

        garph.addEdge("a", "b");
        garph.addEdge("b", "c");
        garph.addEdge("c", "d");
        garph.addEdge("d", "b");


    garph.removeNode("c");

    garph.print();


    }
}
