/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab3;

/**
 * The Testing class contains test cases for the ArrayStack and ArrayQueue classes.
 * It demonstrates the functionality of the stack and queue implementations.
 * The test cases cover pushing, peeking, popping, checking if the stack/queue is empty,
 * and capacity-related operations.
 */
public class Testing {

    /**
     * Entry point of the program.
     * Executes various test cases for ArrayStack and ArrayQueue classes.
     *
     * @param args The command-line arguments (not used in this program).
     */
    
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        

        // Testing Integer stack
        boolean testReturn = stack.push(10);
        System.out.println("Return true if push works: " + testReturn); // Output: true
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Test peeking
        System.out.println("Top element (peek): " + stack.peek()); // Output: 50

        // Test popping elements
        System.out.println("Popped element: " + stack.pop()); // Output: 50
        System.out.println("Popped element: " + stack.pop()); // Output: 40

        // Test checking if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        // Test pushing more elements to expand the capacity
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        System.out.println(stack.peek()); // Output: 90
        stack.push(100);
        System.out.println(stack.peek()); // Output: 100


        // Test checking the size of the stack
        System.out.println("Stack size: " + stack.size()); // Output: 10

        // Test popping all elements
        System.out.println("Popped element: " + stack.pop()); // Output: 100
        System.out.println("Popped element: " + stack.pop()); // Output: 90
        System.out.println("Popped element: " + stack.pop()); // Output: 80
        System.out.println("Popped element: " + stack.pop()); // Output: 70
        System.out.println("Popped element: " + stack.pop()); // Output: 60
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 20
        
        // Test checking if the stack is empty after popping all but 1 element
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        // Pop the final element
        System.out.println("Popped element: " + stack.pop()); // Output: 10

        // Test checking if the stack is empty after popping all elements
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
        
        // Test pushing elements again
        stack.push(200);
        stack.push(300);

        // Test peeking after pushing new elements
        System.out.println("Top element (peek): " + stack.peek()); // Output: 300

        // Testing String stack
        ArrayStack<String> stringStack = new ArrayStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("Peek: " + stringStack.peek()); // Output: "World"

        String str = stringStack.pop(); // Removes and returns the top element ("World")
        System.out.println("Popped value: " + str); // Output: "World"

        System.out.println("Is stringStack empty? " + stringStack.isEmpty()); // Output: false
        System.out.println("stringStack size: " + stringStack.size()); // Output: 10
        
        stringStack.pop(); // Removes the last element
        System.out.println("Is stringStack empty? " + stringStack.isEmpty()); // Output: true
        System.out.println();
        
        

        // Test Integer Queue
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Test peek
        System.out.println("Front element (peek): " + queue.peek()); // Output: 10

        // Test checking the capacity of the queue
        System.out.println("Queue capacity: " + queue.capacity()); // Output: 7

        // Test dequeue
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 10
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 20

       

        // Test enqueueing more elements
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        
        // Test peek
        System.out.println("Front element (peek): " + queue.peek()); // Output: 30

        // Test reset
        queue.reset();
        System.out.println("Capacity after reset: " + queue.capacity()); // Output: 10
        
        
        // Test String Queue
        ArrayQueue<String> stringQueue = new ArrayQueue<>();
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");

        // Test peek and dequeue for String queue
        System.out.println("Front element (peek): " + stringQueue.peek()); // Output: "Hello"
        String str2 = stringQueue.dequeue();
        System.out.println("Dequeued value: " + str2); // Output: "Hello"

        // Test checking the capacity of the String queue
        System.out.println("String queue capacity: " + stringQueue.capacity()); // Output: 9

        

        // Test enqueueing more elements
        stringQueue.enqueue("Harry");
        stringQueue.enqueue("Ron");
        stringQueue.enqueue("Hermione");
        
        // Test peek and dequeue for String queue
        System.out.println("Front element (peek): " + stringQueue.peek()); // Output: "World"

        // Test reset for String queue
        stringQueue.reset();
        // Test checking the capacity of the String queue
        System.out.println("String queue capacity: " + stringQueue.capacity()); // Output: 10
    }
}


    

