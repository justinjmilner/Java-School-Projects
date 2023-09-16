package Lab4;

/**
 * A generic node class used in the implementation of a linked list.
 *
 * @param <T> the type of data held by the node
 */
public class Node<T> {
    public Node<T> next;
    public Node<T> previous;
    public T data;
    
    /**
     * Constructs a new node with the given data.
     *
     * @param data the data to be stored in the node
     */
    public Node(T data) {
        next = null;
        previous = null;
        this.data = data;
    }
}
