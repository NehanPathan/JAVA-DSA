import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph {

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {

        var node = new Node(label);

        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        // if(!nodes.containsKey(from) || !nodes.containsKey(to))
        // throw new IllegalArgumentException();

        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected with " + targets);
        }
    }

    public void removeNode(String label) {

        var node = nodes.get(label);

        if (node == null)
            return;

        nodes.remove(label);
        adjacencyList.remove(node);

        for (var source : adjacencyList.keySet())
            adjacencyList.get(source).remove(node);

        adjacencyList.remove(node);
        nodes.remove(label);

    }

    public void removeEdge(String from, String to) {

        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    //Donot write name with implementation type ie recursively/iteratively (Here we write only for understanding)
    public void traverseDepthFirstRecursively(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;

        traverseDepthFirst(node, new HashSet<>());
    }

    private void traverseDepthFirst(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for (var neighbourNode : adjacencyList.get(root)) {
            if (!visited.contains(neighbourNode))
                traverseDepthFirst(neighbourNode, visited);

        }

    }

    public void traverseDepthFirstIteratively(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            // mosh way
            var current = stack.pop();
            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);
            for (var neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }

            // my way -> //not applicable in circular
            // var current = stack.pop();
            
            // System.out.println(current);
        
            // for (var neighbour : adjacencyList.get(current)) {
            //     if (!visited.contains(neighbour)) {
            //         stack.push(neighbour);
            //          visited.add(neighbour);
            //     }
            // }
        }

    }

}
