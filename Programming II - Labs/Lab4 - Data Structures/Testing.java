/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package Lab4;

/**
 * A class for testing the LinkedList class and its Stack implementation.
 * The main method contains various test cases to verify the functionality
 * of the LinkedList class and its Stack methods.
 * 
 * The test cases cover adding elements to the list, retrieving elements
 * at specific indexes, checking the size of the list, testing the indexOf
 * method, creating a cut list from the original list, removing elements
 * from the cut list, reversing the cut list, and testing the clear method.
 * Additionally, test cases for the Stack implementation include testing
 * the isEmpty, push, pop, and peek methods.
 * 
 * 
 * Test outputs are printed to the console to verify the expected behavior
 * of the LinkedList class and Stack methods.
 * 
 * 
 * Note: The test cases assume correct implementations of the LinkedList
 * and Stack classes. Any incorrect implementations may result in unexpected
 * behavior and test failures.
 * 
 *
 * @author C0535365 Justin milner
 */

public class Testing {

    /**
     * The main method contains various test cases to verify the functionality
     * of the LinkedList class and its Stack methods. Test outputs are printed
     * to the console to verify the expected behavior.
     *
     * @param args the command line arguments (not used in this context)
     */
    
    public static void main(String[] args) {
        
        // Create a LinkedList to test
        LinkedList<String> linkedList = new LinkedList<>();

        // Test adding elements to the list
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");
        linkedList.add("Grapes", 3);
        linkedList.add("Watermelon", 0);

        // Test size and get methods
        System.out.println("Size of the list: " + linkedList.size());
        System.out.println("Element at index 2: " + linkedList.get(2));
        System.out.println("First element: " + linkedList.first());
        System.out.println("Last element: " + linkedList.last());

        // Test indexOf method
        System.out.println("Index of 'Banana': " + linkedList.indexOf("Banana"));
        System.out.println("Index of 'Watermelon': " + linkedList.indexOf("Watermelon"));

        // Test cut method
        List<String> cutList = linkedList.cut(2);
        System.out.println("Cut list size: " + cutList.size());
        

        // Test remove method
        String removedElement = cutList.remove(1);
        System.out.println("Removed element: " + removedElement);

        // Test reverse method
        cutList.reverse();
        System.out.println("Reversed list index of 'Grapes': " + cutList.indexOf("Grapes"));

        // Test clear method
        cutList.clear();
        System.out.println("List size after clearing: " + cutList.size());
        
        // Create a LinkedList to test
        LinkedList<Integer> stack = new LinkedList<>();

        // Test isEmpty method
        System.out.println("Is the stack empty? " + stack.isEmpty()); // Should print true

        // Test push method
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Test isEmpty method after pushing elements
        System.out.println("Is the stack empty after pushing elements? " + stack.isEmpty()); // Should print false

        // Test peek method
        System.out.println("Top element in the stack: " + stack.peek()); // Should print 30

        // Test pop method
        int poppedElement = stack.pop();
        System.out.println("Popped element from the stack: " + poppedElement); // Should print 30
        System.out.println("Top element in the stack after pop: " + stack.peek()); // Should print 20

        // Test push method after popping elements
        stack.push(40);
        System.out.println("Top element in the stack after push: " + stack.peek()); // Should print 40

        // Test isEmpty method after popping elements and pushing again
        System.out.println("Is the stack empty after popping and pushing? " + stack.isEmpty()); // Should print false
    }
}
