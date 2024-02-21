import java.util.ArrayList;

public class BST {
    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node = " + data;
        }

    }

    private Node root;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        var current = root;
        while (true) {
            if (data < current.data) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else {

                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
        }
    }

    //find char.......

    public boolean find(int data) {
        var current = root;

        while (current != null) {
            if (data < current.data)
                current = current.left;
            if (data > current.data)
                current = current.right;
            else
                return true;
        }
        return false;

    }

    //traversal pre post  inorder

    public void preOrder() {
        preOrder(root);

    }

    public void inOrder() {
        inOrder(root);

    }

    public void postOrder() {
        postOrder(root);

    }

    private void preOrder(Node root) {

        if (root == null)
            return;

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root) {

        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    private void postOrder(Node root) {

        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    //Height of tree

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }


    //find is leaf node

    private boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public int minForBinaryTree() {
        return min(root);
    }

    //min of BST
    // O(logn)
    public int minForBST() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last.data;

    }

    //min of normal binary tree
    // O(n)
    private int min(Node root) {
        if (isLeaf(root))
            return root.data;

        var left = min(root.left);
        var right = min(root.right);
        return Math.min(Math.min(left, right), root.data);
    }


    // two BST equal or not
    public boolean equals(BST otherTree) {
        if (otherTree == null)
            return false;
        return equals(root, otherTree.root);
    }

    private boolean equals(Node root1, Node root2) {

        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 != null)
            return root1.data == root2.data && equals(root1.left, root2.left) && equals(root1.right, root2.right);

        return false;

    }

    // value is in range or not

    private boolean isWithinRange(int value, int min, int max) {
        return value >= min && value <= max;
    }


    // valid BST or not
    public boolean validity() {

        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (!isWithinRange(root.data, min, max))
            return false;
        return isBST(root.left, min + 1, root.data - 1) && isBST(root.right, root.data + 1, max - 1);

    }


    // find all nodes at K level
    public ArrayList<Integer> nodes_At_Klevel(int k) {
        var list = new ArrayList<Integer>();
        if (!isWithinRange(k, 0, height() + 1)) 
            throw new IllegalArgumentException();
            
            nodes_At_Klevel(root, k, list);
            return list;
    }

    private void nodes_At_Klevel(Node root, int k, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (k == 1) {
            list.add(root.data);
            return;
        }

        nodes_At_Klevel(root.left, k - 1, list);
        nodes_At_Klevel(root.right, k - 1, list);
    }

    //BFS traversal (level order traversal)
    public void traversalLevelOrder(){
        for(var i = 0; i <= height(); i++){
            for(var value: nodes_At_Klevel(i+1))
            System.out.println(value);
        }
    }


}
