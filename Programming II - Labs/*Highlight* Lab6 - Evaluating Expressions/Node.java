/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp139.lab6_2023;

/**
 * Represents a node in a tree data structure.
 */
public class Node {

    private Object data; // The data stored in the node
    private Node left;   // Reference to the left child node
    private Node right;  // Reference to the right child node
    private Node next;   // Reference to the next node (used in linked lists)

    /**
     * Constructs a new node with no data and no child nodes.
     */
    public Node() {

    }

    /**
     * Constructs a new node with the specified data and no child nodes.
     *
     * @param data The data to be stored in the node.
     */
    public Node(Object data) {
        this.data = data;
    }

    /**
     * Constructs a new node with the specified data and child nodes.
     *
     * @param data The data to be stored in the node.
     * @param left The left child node.
     * @param right The right child node.
     */
    public Node(Object data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // Setter and getter methods
    /**
     * Sets the data stored in the node.
     *
     * @param data The data to be set in the node.
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Sets the next node reference.
     *
     * @param next The next node to be linked.
     */
    public void setNextNode(Node next) {
        this.next = next;
    }

    /**
     * Retrieves the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public Object getData() {
        return data;
    }

    /**
     * Retrieves the next node reference.
     *
     * @return The next node linked to this node.
     */
    public Node getNextNode() {
        return next;
    }

    // Other methods for left and right nodes
    /**
     * Retrieves the left child node of the current node.
     *
     * @return The left child node.
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Sets the left child node of the current node.
     *
     * @param newLeft The new left child node.
     */
    public void setLeft(Node newLeft) {
        left = newLeft;
     }

    /**
     * Retrieves the right child node of the current node.
     *
     * @return The right child node.
     */
    public Node getRight() {
        return right;
    }

    /**
     * Sets the right child node of the current node.
     *
     * @param newRight The new right child node.
     */
    public void setRight(Node newRight) {
        right = newRight;
    }

    /**
     * Checks if the current node has a left child.
     *
     * @return True if the node has a left child, false otherwise.
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * Checks if the current node has a right child.
     *
     * @return True if the node has a right child, false otherwise.
     */
    public boolean hasRight() {
        return right != null;
    }
}
