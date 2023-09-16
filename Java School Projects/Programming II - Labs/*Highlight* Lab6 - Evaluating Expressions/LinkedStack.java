package comp139.lab6_2023;



/**
 * Represents a stack implemented using a linked list of nodes.
 */
public class LinkedStack {

    private Node top;

    /**
     * Constructs an empty linked stack.
     */
    public LinkedStack() {
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Pushes an item onto the stack.
     *
     * @param newItem The item to be pushed onto the stack.
     */
    public void push(Object newItem) {
        Node node = new Node(newItem);
        if (top != null) {
            node.setNextNode(top); // Set the next reference of the new node to the current top
        }
        top = node; // Update the top reference to the new node
    }

    /**
     * Pops an item from the top of the stack.
     *
     * @return The popped item.
     * @throws Exception if the stack is empty.
     */
    public Object pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        Node node = top;
        top = top.getNextNode(); // Update the top reference to the next node
        return node.getData(); // Return the data from the popped node
    }


    /**
     * Peeks at the item on top of the stack without removing it.
     *
     * @return The item on top.
     * @throws Exception if the stack is empty.
     */
    public Object peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return top.getData();
    }
}
