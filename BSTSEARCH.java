class BSTSEARCH {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BSTSEARCH() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    public static void main(String[] args) {
        BSTSEARCH tree = new BSTSEARCH();
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            tree.insert(value);
        }

        System.out.println("In-order traversal of the BST:");
        tree.inorder();

        int searchKey = 40;
        System.out.println("\nSearch for " + searchKey + ":");
        if (tree.search(searchKey)) {
            System.out.println(searchKey + " is found in the BST.");
        } else {
            System.out.println(searchKey + " is not found in the BST.");
        }
    }
}
