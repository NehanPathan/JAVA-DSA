import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.management.Query;

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

    // Donot write name with implementation type ie recursively/iteratively (Here we
    // write only for understanding)
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
            // if (!visited.contains(neighbour)) {
            // stack.push(neighbour);
            // visited.add(neighbour);
            // }
            // }
        }

    }

    public void traverseBreadthFirst(String root) {
        var node = nodes.get(root);

        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            var current = queue.remove();
            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (var neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour))
                    queue.add(neighbour);
            }
        }
    }

    public List<String> topologicalSort(String root) {
        var node = nodes.get(root);

        if (node == null)
            throw new IllegalArgumentException();

        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (var node2 : nodes.values())
            topologicalSort(node2, visited, stack);

        List<String> sortedList = new ArrayList<>();

        while (!stack.empty())
            sortedList.add(stack.pop().label);

        return sortedList;

    }

    private void topologicalSort(Node root, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(root))
            return;

        visited.add(root);

        for (var neighbourNode : adjacencyList.get(root))
            topologicalSort(neighbourNode, visited, stack);

        stack.push(root);

    }

    public boolean hasCycle() {

        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            var current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
                return true;
        }
        return false;

    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (var neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour))
                continue;

            if (visiting.contains(neighbour))
                return true;

            if (hasCycle(neighbour, all, visiting, visited))
                return true;
        }
        visiting.remove(node);
        visited.add(node);

        return false;
    }

}
