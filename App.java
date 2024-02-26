
public class App {
    public static void main(String[] args) throws Exception {
     var garph = new Graph();

        garph.addNode("a");
        garph.addNode("b");
        garph.addNode("c");
        garph.addNode("d");

        garph.addEdge("a", "b");
        garph.addEdge("b", "d");
        garph.addEdge("d", "c");
        garph.addEdge("a", "c");    




    // garph.traverseDepthFirstRecursively("a");
    garph.traverseDepthFirstIteratively("a");


    }
}
