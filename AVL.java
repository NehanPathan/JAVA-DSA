public class AVL {
    private class AVLNode {
        private int height;
        private int data;
        private AVLNode left;
        private AVLNode right;

        public AVLNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node = " + data;
        }
    }

    private AVLNode root;

    public void insert(int data) {
        root = insert(root, data);
    }

    // insert node
    private AVLNode insert(AVLNode root, int data) {

        if (root == null)
            return new AVLNode(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        setHeight(root);
        
        return balance(root);

    }

    private void setHeight(AVLNode node) {
        node.height = 1 + Math.max(heightAVL(node.left), heightAVL(node.right));

    }

    private AVLNode balance(AVLNode root) {

        if (isLeftHeavy(root)) {
            if (balanceFactor(root.left) < 0)
                root.left = leftRotate(root.left);

            return rightRotate(root);

        }

        else if (isRightHeavy(root)) {
            if (balanceFactor(root.right) > 0)
                root.right = rightRotate(root.right);

            return leftRotate(root);

        }
        return root;

    }

    private AVLNode leftRotate(AVLNode root) {
        var newRoot = root.right;

        root.right = newRoot.left;
        newRoot.left = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rightRotate(AVLNode root) {
        var newRoot = root.left;

        root.left = newRoot.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : heightAVL(node.left) - heightAVL(node.right);
    }

    // Height of node
    private int heightAVL(AVLNode node) {
        return (node == null) ? -1 : node.height;

    }

}
