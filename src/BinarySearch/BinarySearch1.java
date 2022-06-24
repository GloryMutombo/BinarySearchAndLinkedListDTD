package BinarySearch;

import com.sun.jdi.Value;

import java.sql.SQLOutput;

public class BinarySearch1 {
    Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);

        } else {
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            System.out.println(value + "exist");
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {

        return containsNodeRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }


        if (value == current.value) {
            // Node to delete found
            // ... code to delete the node will go here
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        if (current.left == null && current.right == null) {
            return null;
        }
        if (current.right == null) {
            return current.left;
        }

        if (current.left == null) {
            return current.right;
        }
        current.right = deleteRecursive(current.right, value);
        int smallestValue = findSmallestValue(current.right);
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;


    }

    private int findSmallestValue(Node root) {

        return root.left == null ? root.value : findSmallestValue(root.left);


    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }


    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    private void traversePostOrderRec(Node node) {
        if (node != null) {
            traversePostOrderRec(node.left);
            traversePostOrderRec(node.right);
            System.out.print(" " + node.value);
        }
    }


    public void PreOrder() {
        traversePreOrder(root);
    }

    public void InOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrderRec(root);
    }

}
