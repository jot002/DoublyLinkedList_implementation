/*
 * NAME: Jonathan Tran
 * PID: A15967290
 */

/**
 * DLLQueue is created to replicate a queue using a doubly linked list.
 * In this class, the beginning of the queue is at the head of the
 * doubly linked list and the end of the queue is at the tail.
 *
 * @author Jonathan Tran
 * @since 10/27/2021
 */
public class DLLQueue<T> {

    private DoublyLinkedList<T> queue;

    /**
     * This constructor sets the instance variable queue to a new
     * doubly linked list.
     */
    public DLLQueue() {
        this.queue = new DoublyLinkedList<T>();
    }

    /**
     * This method checks the size of the queue
     * @return the size of the queue
     */
    public int size() {
        return this.queue.size();
    }

    /**
     * This method checks if the queue is empty
     * @return true if it is empty
     *         false if it is not
     */
    public boolean isEmpty() {
        if (this.queue.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * This method pushes an element into the queue
     * @param data T: an element getting pushed into the queue
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.queue.add(data);
    }

    /**
     * This method pops the element from the queue that is at the
     * beginning of the queue
     * @return the removed element
     */
    public T dequeue() {
        if (this.queue.size() == 0) {
            return null;
        }
        return this.queue.remove(0);
    }

    /**
     * This method looks at the element at the beginning of the queue
     * @return the element at the beginning of the queue
     */
    public T peek() {
        if (this.queue.size() == 0) {
            return null;
        }
        return this.queue.get(0);
    }
}
