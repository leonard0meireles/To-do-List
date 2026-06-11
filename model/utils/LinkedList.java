/**
 * @author Devsuperior
 * @apiNote This class implements a generic linked list data structure.
 * It provides methods to add, remove, and access elements in the list.
 * The linked list is implemented using a nested Node class, which contains a value and a reference to the next node in the list.
 * The LinkedList class includes methods to check if the list is empty, get the size of the list, add elements at the start, end, or a specific position, get elements by index, check if an element exists in the list, find the index of an element, remove elements by index or value, convert the list to an array, and generate a string representation of the list.
 * The LinkedList class is designed to be flexible and can store any type of data, as it uses generics (T) to allow for different types of elements to be stored in the list.
 * The class also includes error handling for cases such as trying to access an index that is out of bounds or trying to remove an element that does not exist in the list.
 * Overall, this implementation of a linked list provides a basic structure for managing a collection of elements in a dynamic way, allowing for efficient insertion and deletion of elements without the need for contiguous memory allocation.
 * Copyright (c) 2024 DevSuperior. All rights reserved.
 * @version 1.0
 * @since 2024-06
 */

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public boolean isEmpty() {
        if (this.head == null)
            return true;
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public void addAtStart(T elem) {
        Node<T> node = new Node<T>(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.size++;
            return;
        }
        Node<T> aux = this.head;
        this.head = node;
        node.setNext(aux);
        this.size++;
    }

    public void addAtEnd(T elem) {
        Node<T> node = new Node<T>(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.size++;
            return;
        }
        Node<T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        this.size++;
    }

    public void addAtPosition(int index, T elem) {
        if (index == 0) {
            this.addAtStart(elem);
            return;
        }
    
        if (this.get(index) == null) {
            this.addAtEnd(elem);
            return;
        }
        
        Node<T> node = new Node<T>(elem);
        Node<T> aux = this.getNode(index - 1);
        node.setNext(aux.getNext());
        aux.setNext(node);
        this.size++;
    }

    public T get(int index) {
        Node<T> current = this.getNode(index);
        if (current != null)
            return current.getValue();
        return null;
    }

    public Node<T> getNode(int index) {
        if (index < 0 || index > this.getSize())
            return null;
        Node<T> current = this.head;
        int i = 0;
        while (i != index) {
            current = current.getNext();
            i++;
        }
        if (current != null)
            return current;
        return null;
    }

    public boolean contains(T elem) {
        int indexElem = this.indexOf(elem);
        if (indexElem != -1) {
            return true;
        }
        return false;
    }

    public int indexOf(T elem) {
        Node<T> current = this.head;
        int i = 0;
        while (current != null) {
            if (current.getValue() == elem)
                return i;
            current = current.getNext();
            i++;
        }
        return -1;
    }

    public T removeAtPosition(int index) {
        if (this.isEmpty() || this.get(index) == null) {
            return null;
        }
        T item = null;
        Node<T> aux = null;
        if (index == 0) {
            item = this.head.getValue();
            this.head = this.head.getNext();
            this.size--;
            return item;
        }
        if (index == this.getSize() - 1) {
            item = this.get(index);
            aux = this.getNode(index - 1);
            aux.setNext(null);
            this.size--;
            return item;
        }
        aux = this.getNode(index - 1);
        item = aux.getNext().getValue();
        aux.setNext(aux.getNext().getNext());
        this.size--;
        return item;
    }

    public boolean remove(T elem) {
        int index = this.indexOf(elem);
        if (this.isEmpty() || index == -1) 
            return false;
        this.removeAtPosition(index);
        return true;
    }

    public Object[] toArray() {
    	
		Object[] vect = new Object[getSize()];
        
    	Node<T> current = this.head;

        for (int i = 0; i < getSize(); i++) {
        	vect[i] = current.getValue();
        	current = current.getNext();
        }
        return vect;
    }

    @Override
    public String toString() {
        if (this.isEmpty() == true) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Node<T> current = this.head;
        while (current.getNext() != null) {
            builder.append(current.getValue()).append(",");
            current = current.getNext();
        }
        builder.append(current.getValue()).append("]");

        return builder.toString();
    }

    class Node<T> {

        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
