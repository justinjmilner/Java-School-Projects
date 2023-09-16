/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Lab3;

import java.util.NoSuchElementException;

/**
 * The ArrayStack class represents a stack data structure implemented using an array.
 * It follows the LIFO (Last In, First Out) principle, where elements are added and removed from the same end.
 *
 * @param <T> the type of elements stored in the stack.
 *            T should be replaced with the actual data type when creating an instance of the class.
 */
public class ArrayStack<T> implements Stack<T> {
    
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array; 
    public int top;
    
    /**
     * Constructs an empty ArrayStack with the default capacity.
     * The default capacity is set to 10 elements.
     */
    public ArrayStack() {
        array = new Object[DEFAULT_CAPACITY];
        top = -1;
    }
    
    /**
     * Checks if the stack is empty or not.
     *
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**
     * Retrieves the top element of the stack without removing it.
     * This operation does not modify the state of the stack.
     *
     * @return the top element of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    @Override
    public T peek() {
        try {
            return (T) array[top];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException("Stack is empty.");
        }
    }
    
    /**
     * Removes and returns the top element of the stack.
     * The element is removed from the stack after this operation.
     *
     * @return the top element of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    @Override
    public T pop() {
        try {
            T element = (T) array[top];
            array[top] = null;
            top--;
            return element;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException("Stack is empty.");
        }
    }
    
    /**
     * Adds an element to the top of the stack.
     * The element is pushed onto the top of the stack.
     *
     * @param e the element to be added to the stack.
     * @return true if the element is successfully pushed, false if the stack is full and the element cannot be added.
     */
    @Override
    public boolean push(T e) {
        try { 
            top++;
            array[top] = e;
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e2) {
            return false;
        }
    }
    
    /**
     * Gets the current size of the stack.
     *
     * @return the number of elements currently stored in the stack.
     */
    @Override
    public int size() {
        return array.length;
    }
}
