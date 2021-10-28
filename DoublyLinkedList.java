/*
 * NAME: Jonathan Tran
 * PID: A15967290
 */

import java.util.AbstractList;

/**
 * DoublyLinkedList is created to replicate a doubly linked list with nodes
 * that have elements. The head and tail are dummy nodes.
 *
 * @author Jonathan Tran
 * @since 10/27/2021
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            this.data = element;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            this.data = element;
            this.next = nextNode;
            this.prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            this.data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            return this.data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return this.prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            if (this == head) {
                return;
            }
            if (this == tail) {
                return;
            }
            Node beforeNode = this.getPrev();
            Node afterNode = this.getNext();
            beforeNode.setNext(afterNode);
            afterNode.setPrev(beforeNode);
            nelems--;
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.nelems = 0;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        Node beforeTail = this.tail.getPrev();
        Node addedNode = new Node(element, tail, beforeTail);
        beforeTail.setNext(addedNode);
        tail.setPrev(addedNode);
        nelems ++;
        return true;
    }

    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * @param element data to be added
     * @param index the index where the data will be added
     * @throws NullPointerException if data received is null
     * @throws IndexOutOfBoundsException if the index is less than 0
     * @throws IndexOutOfBoundsException if the index is greater than nelems
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index > nelems) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        if (index == 0) {
            Node afterHead = this.head.getNext();
            Node addedNode = new Node(element, afterHead, head);
            head.setNext(addedNode);
            afterHead.setPrev(addedNode);
            nelems++;
        } else if (index < nelems) {
            Node currentNode = this.head.next;
            // iterates to the node at given index
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            Node beforeNode = currentNode.getPrev();
            Node addedNode = new Node(element, currentNode, beforeNode);
            currentNode.setPrev(addedNode);
            beforeNode.setNext(addedNode);
            nelems++;
        } else {
            Node beforeTail = this.tail.getPrev();
            Node addedNode = new Node(element, tail, beforeTail);
            beforeTail.setNext(addedNode);
            tail.setPrev(addedNode);
            nelems ++;
        }
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * @param element an object that is to be checked if it is inside
     * the linked list
     * @return boolean true if the linked list contains the element
     * false if the linked list does not
     */
    @Override
    public boolean contains(Object element) {
        T data = (T)element;
        Node currentNode = this.head.next;
        while (currentNode != this.tail) {
            if (currentNode.getElement() == data) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * @param index the position where the node will be taken
     * @return T the data of the node at the position
     * @throws IndexOutOfBoundsException if index is less than 0 or more
     * than (nelems-1)
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index > nelems - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = this.head.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        T returnedData = currentNode.getElement();
        return returnedData;
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * @param index and int that is used to get the node
     * @return Node a node that is at the index
     */
    private Node getNth(int index) {
        Node currentNode = this.head.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    /**
     * Determine if the list empty
     *
     * @return boolean that returns true if the linked list is empty,
     * false if it is not
     */
    @Override
    public boolean isEmpty() {
        if (nelems == 0) {
            return true;
        }
        return false;
    }

    /**
     * Remove the element from position index in the list
     *
     * @param index an int that tells where the node will be removed
     * @return T the data of the node that is removed
     * @throws IndexOutOfBoundsException if index is less than 0 or more
     * than (nelems-1)
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index > nelems - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = this.head.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        T returnedData = currentNode.getElement();
        Node beforeNode = currentNode.getPrev();
        Node afterNode = currentNode.getNext();
        beforeNode.setNext(afterNode);
        afterNode.setPrev(beforeNode);
        nelems--;
        return returnedData;
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * @param index an int that tells where the element will be set
     * @param element the element that will be placed at the index
     * @return T the data of the node that is changed
     * @throws IndexOutOfBoundsException if index is less than 0 or more
     * than (nelems-1)
     * @throws NullPointerException if element is null
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index > nelems - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        Node currentNode = this.head.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        T returnedData = currentNode.getElement();
        currentNode.setElement(element);
        return returnedData;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * @return the size of the linked list
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * @return the sentence that describes the whole linked list
     */
    @Override
    public String toString() {
        String sentence = "[(head) ";
        Node currentNode = this.head.next;
        while (currentNode != this.tail) {
            sentence = sentence + "-> " +
                    currentNode.data.toString() + " ";
            currentNode = currentNode.next;
        }
        sentence = sentence + "-> (tail)]";
        return sentence;
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     *
     * @param base an int that is used to determine if the index
     * will be removed
     */
    public void removeMultipleOf(int base) {
        if (base < 1) {
            throw new IllegalArgumentException();
        }
        Node currentNode = this.head.next;
        int i = 0;
        while (currentNode != this.tail) {
            if ((i % base) == 0) {
                currentNode.remove();
            }
            i++;
            currentNode = currentNode.next;
        }
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * @param other a doubly linked list that will swap some elements
     * with the doubly linked list from the class
     * @param splitIndex an int that tells when the switch will stop
     */
    public void swapSegment(DoublyLinkedList other, int splitIndex) {
        Node myCurrent = this.head.next;
        Node otherCurrent = other.head.next;
        DoublyLinkedList<T> mySwitch = new DoublyLinkedList<T>();
        DoublyLinkedList<T> otherSwitch = new DoublyLinkedList<T>();
        int i = 0;
        // keeps going while the index is not to splitIndex
        while (i <= splitIndex) {
            mySwitch.add(myCurrent.getElement());
            otherSwitch.add(otherCurrent.getElement());
            myCurrent = myCurrent.getNext();
            otherCurrent = otherCurrent.getNext();
            i++;
        }
        // removes from the original
        for (int j = 0; j <= splitIndex; j++) {
            this.remove(j);
            other.remove(j);
        }
        // adds the swapped elements
        for (int j = 0; j <= splitIndex; j++) {
            this.set(j, otherSwitch.get(j));
            other.set(j, mySwitch.get(j));
        }
    }
}
