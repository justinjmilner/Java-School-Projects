/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Lab3;

import java.util.NoSuchElementException;

/**
 * The ArrayQueue class represents a queue data structure implemented using a circular array.
 * A queue follows the FIFO (First In, First Out) principle, where elements are added at the end (enqueue)
 * and removed from the front (dequeue).
 *
 * @param <T> the type of elements stored in the queue.
 *            T should be replaced with the actual data type when creating an instance of the class.
 */
public class ArrayQueue<T> implements Queue<T> {
    
    private static final int DEFAULT_SIZE = 10;
    private Object[] queue;
    private int bottom;
    private int front;
    
    /**
     * Constructs an empty ArrayQueue with the default capacity.
     * The default capacity is set to 10 elements.
     */
    public ArrayQueue() {
        queue = new Object[DEFAULT_SIZE];
        bottom = 0;
        front = 0;
    }
            
    /**
     * Gets the number of vacant indices in the queue.
     * The vacant indices represent the remaining capacity of the queue.
     *
     * @return the number of vacant indices in the queue.
     */
    @Override
    public int capacity() {
        int vacantIndices = 0;
        for (Object indice : queue) {
            if (indice == null) {
                vacantIndices++;
            }
        }
        return vacantIndices;
    }
    
    /**
     * Removes and returns the front element of the queue.
     * The element is removed from the queue after this operation.
     *
     * @return the front element of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    @Override
    public T dequeue() {
        if (capacity() == 10) {
            throw new NoSuchElementException("Queue is empty.");
        }

        T element = (T) queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        return element;
    }
    
    /**
     * Adds an element to the end of the queue.
     * The element is enqueued to the back of the queue.
     *
     * @param e the element to be added to the queue.
     * @throws ArrayIndexOutOfBoundsException if the queue is full and the element cannot be added.
     */
    @Override
    public void enqueue(T e) {
        if (capacity() != 0) {
            queue[bottom] = e;
            bottom = (bottom + 1) % queue.length;
        }
        else { 
            throw new ArrayIndexOutOfBoundsException("Queue is full.");
        }
    }
        
    /**
     * Retrieves the front element of the queue without removing it.
     * This operation does not modify the state of the queue.
     *
     * @return the front element of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    @Override
    public T peek() {
        try {
            return (T) queue[front]; 
        }
        catch (NullPointerException e) {
            throw new NoSuchElementException("Queue is empty.");
        }
    }
    
    /**
     * Resets the queue to its initial state.
     * After calling this method, the queue should be empty.
     */
    @Override
    public void reset() {
        queue = new Object[DEFAULT_SIZE];
        bottom = 0;
        front = 0;
    }   
}
