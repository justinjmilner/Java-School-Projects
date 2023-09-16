/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Midterm;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author C0535365 Jusitn Milner
 */
public class midterm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // test swap items in list
        int[] num1 = {1, 2, 3, 9};
        int[] num2 = {4, 5, 6, 7};

        System.out.println("Before swapping:");
        System.out.println("num1: " + Arrays.toString(num1));
        System.out.println("num2: " + Arrays.toString(num2));

        swapNumbers(num1, num2);

        System.out.println("After swapping:");
        System.out.println("num1: " + Arrays.toString(num1));
        System.out.println("num2: " + Arrays.toString(num2));
        System.out.println();
        
        
        
        
        
        // test is palindrome
        String str1 = "racecar";
        String str2 = "hello";

        System.out.println(str1 + " is a palindrome? " + isPalindrome(str1));
        System.out.println(str2 + " is a palindrome? " + isPalindrome(str2));
        
        System.out.println();
        
        
        
        // test for stack qeustions
        ArrayStack stack = new ArrayStack(5);

        System.out.println("Is the stack empty? " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Is the stack empty? " + stack.isEmpty());

        System.out.println(stack.pop() + " has been popped from the stack.");
        System.out.println(stack.pop() + " has been popped from the stack.");

        System.out.println("Is the stack empty? " + stack.isEmpty());

        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        
        System.out.println("top element:" + stack.peek());

        System.out.println("Is the stack empty? " + stack.isEmpty());

        System.out.println(stack.pop() + " has been popped from the stack."); 
        
        System.out.println("Current minimum element in the stack: " + stack.getMin());
        System.out.println("Current maximum element in the stack: " + stack.getMax());
        
        System.out.println();
        
        
        
        // test queue questions
        ArrayQueue queue = new ArrayQueue(5);

        System.out.println("Is the queue empty? " + queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Is the queue empty? " + queue.isEmpty());

        System.out.println(queue.dequeue() + " has been dequeued from the queue.");
        System.out.println(queue.dequeue() + " has been dequeued from the queue.");
        System.out.println(queue.dequeue() + " has been dequeued from the queue.");
      
        System.out.println("Is the queue empty? " + queue.isEmpty());
        
        System.out.println();
        
        
        // test valid stack or queue algorithm
        int[] sequence1 = {2, 4, 5, 6};
        int[] sequence2 = {4, 3, 6, 1};
        int[] sequence3 = {1, 2, 3, 4};

        System.out.println("Sequence 1: " + (isValidStackOrQueue(sequence1) ? "Valid" : "Invalid")); // valid
        System.out.println();
        System.out.println("Sequence 2: " + (isValidStackOrQueue(sequence2) ? "Valid" : "Invalid")); // invalid
        System.out.println();
        System.out.println("Sequence 3: " + (isValidStackOrQueue(sequence3) ? "Valid" : "Invalid")); // valid 
        System.out.println();
    }  

    
    
    // Question 1
    static public void swapNumbers(int[] num1, int[] num2) {
        if (num1.length != num2.length) {
            throw new IllegalArgumentException("Arrays must have the same length.");
        }
        for (int i = 0; i < num1.length; i++) {
            int temp = num1[i];
            num1[i] = num2[i];
            num2[i] = temp;
        }
    }
        
    // Question 2
    static public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    // Question 3, 4, 7, 8
    static public class ArrayStack {
    private int[] array;
    private int top;
    private int capacity;
    private int minValue = Integer.MAX_VALUE;
    private int maxValue = Integer.MIN_VALUE; 

    public ArrayStack(int size) {
        this.array = new int[size];
        this.top = -1;
        this.capacity = size;
    }

    public void push(int val) {
        if (top == capacity - 1) {
            throw new IndexOutOfBoundsException("Stack is full, cannot push item to stack.");
        } else {
            if (val < minValue) {
                minValue = val;
            }
            if (val > maxValue) {
                maxValue = val;
            }
            top++;
            array[top] = val;
            System.out.printf("%d has been pushed onto the Stack.%n", val);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        } else {
            int val = array[top];
            top--;
            if (val == minValue) {
                updateMinValue();
            }
            if (val == maxValue) {
                updateMaxValue();
            }
            return val;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return array[top];
    }

    public int getMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return minValue;
    }

    public int getMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return maxValue;
    }

    private void updateMinValue() {
        if (isEmpty()) {
            minValue = Integer.MAX_VALUE;
        } else {
            minValue = array[0];
            for (int i = 1; i <= top; i++) {
                if (array[i] < minValue) {
                    minValue = array[i];
                }
            }
        }
    }

    private void updateMaxValue() {
        if (isEmpty()) {
            maxValue = Integer.MIN_VALUE;
        } else {
            maxValue = array[0];
            for (int i = 1; i <= top; i++) {
                if (array[i] > maxValue) {
                    maxValue = array[i];
                }
            }
        }
    }
}


    // Question 5, 6, 9
    static public class ArrayQueue {
        private int[] array;
        private int front;
        private int rear;
        private int capacity;
        private int size;
        private int maxValue;

        public ArrayQueue(int capacity) {
            this.array = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.capacity = capacity;
            this.size = 0;
            this.maxValue = Integer.MIN_VALUE;
        }

        public void enqueue(int val) {
            if (size == capacity) {
                throw new IndexOutOfBoundsException("Queue is full, cannot enqueue item."); 
            } else {
                if (val > maxValue) {
                    maxValue = val;
                }
                rear = (rear + 1) % capacity;
                array[rear] = val;
                size++;
                System.out.printf("%d has been enqueued into the Queue.%n", val);
            }
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty."); 
            } else {
                int dequeuedValue = array[front];
                front = (front + 1) % capacity;
                size--;
                if (dequeuedValue == maxValue) {
                    updateMaxValue();
                }
                return dequeuedValue;
            }
        }

        public boolean isEmpty() {
            return (size == 0);
        }
        
        public int peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty."); 
            }
            return array[front];
        }
        
        public int getMax() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty.");
            }
            return maxValue;
        }
        
        private void updateMaxValue() {
            if (isEmpty()) {
                maxValue = Integer.MIN_VALUE; // If the queue becomes empty, reset maxValue
            } else {
                maxValue = array[front];
                for (int i = front + 1; i <= rear; i++) {
                    if (array[i] > maxValue) {
                        maxValue = array[i];
                    }
                }
            }
        }
    }
    

    // Question 11
    public static boolean isValidStackOrQueue(int[] sequence) {
        boolean valid = true;
        int evenCount = 0;
        int oddCount = 0;

        for (int element : sequence) {
            if (element % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        ArrayStack stack = new ArrayStack(evenCount);
        ArrayQueue queue = new ArrayQueue(oddCount);

        for (int num : sequence) {
            if (num % 2 == 0) {
                stack.push(num);
            } else {
                queue.enqueue(num);
            }
        }
                     
        while (true) {
            if(stack.isEmpty() || queue.isEmpty()) {
                break;
            }
            int stackTop = stack.pop(); 
            int queueFront = queue.dequeue();  
            if (stackTop == queueFront) {
                stack.pop();
                queue.dequeue();
            } 
            if (!queue.isEmpty()) {
                if (queueFront < queue.peek()) {
                    valid = true;
                    break;
                }
                else {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }
}




