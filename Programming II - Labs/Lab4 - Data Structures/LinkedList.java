/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Lab4;

import java.util.NoSuchElementException;

/**
 * A custom implementation of a linked list that also functions as a stack.
 * <p>
 * This LinkedList class provides methods to add elements, remove elements,
 * get the first and last elements, find the index of an element, cut the
 * list at a specific index, clear the list, and reverse the order of elements.
 * Additionally, it implements the Stack interface and provides methods for
 * stack operations like push, pop, peek, and checking if the stack is empty.
 * </p>
 * <p>
 * The LinkedList class uses the Node class to create nodes that hold the data
 * elements and maintain the links between nodes to form the linked data structure.
 * </p>
 * <p>
 * Note: The LinkedList class is generic and can hold elements of any type.
 * </p>
 *
 * @param <E> the type of elements held in the linked list
 * @see Stack
 * @see Node
 * @see List
 * @see NoSuchElementException
 * @see IndexOutOfBoundsException
 */

public class LinkedList<E> implements List<E>, Stack<E> {
    private Node<E> head;
    private Node<E> tail;
    
    public LinkedList(){
        head = null;
        tail = null;
    }
    
    @Override
    public void add(E element) {
        Node<E> newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.data = element;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            newNode.data = element;
        }
    }

    @Override
    public void add(E element, int index) {
        int tempSize = size();
        index = (index + tempSize) % tempSize;
        Node<E> temp = head;
        Node newNode = new Node(element);
        try {
            while (index > 0) {
                temp = temp.next;
                index--; 
            }
            if (temp.next == null) {
                temp.next = newNode;
                tail = newNode;
            }
            else {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }
    

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public List<E> cut(int index) {
        LinkedList<E> newList = new LinkedList();
        int tempSize = size();
        index = (index + tempSize) % tempSize;
        Node<E> temp = head;
        try {
            while (index > 0) {
                temp = temp.next;
                index--; 
            }
            newList.head = temp;
            return newList;
        }
        catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public E first() {
        if (head != null) {
            return head.data;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public E get(int index) {
        int tempSize = size();
        index = (index + tempSize) % tempSize;
        Node<E> temp = head;
        try {
            while (index > 0) {
                temp = temp.next;
                index--; 
            }
            return (E) temp.data;
        }
        catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        Node<E> temp = head;
        try {
            while (true){
                if (temp.data.equals(element)) {
                    break;
                }
                temp = temp.next;
                index++;
            }
        }
        catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
        return index;
    }

    @Override
    public E last() {
        if (tail != null) {
            return tail.data;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public E remove(int index) {
        int tempSize = size();
        index = (index + tempSize) % tempSize;
        Node<E> temp = head;
        Node<E> tempData;
        try {
            while (index > 0) {
                temp = temp.next;
                index--; 
            }
            tempData = temp;
            temp.previous = temp;
            temp.next = temp.next.next;
        }
        catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
        return (E) tempData.data;
    }

    @Override
    public void reverse() {
        for (int i = 0; i < size(); i++) {
            int index = 0;
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;    
                index++;
            }
            add(temp.data, 0);
            remove(index);
        }
    }

    @Override
    public int size() {
        int size = 0;
        Node<E> temp = head;
        while (temp != null) {
            temp = temp.next;
            size++; 
        }
        return size; 
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E peek() {
        return head.data;
    }

    @Override
    public E pop() {
        E data = head.data;
        head = head.next;
        return data;
    }

    @Override
    public boolean push(E e) {
        if (head == null) {
            Node<E> newNode = new Node(e);
            head = newNode;
            return true;
        }
        Node<E> newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        return true;
    }
}
