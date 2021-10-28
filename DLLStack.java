/*
 * NAME: Jonathan Tran
 * PID: A15967290
 */

/**
 * DLLStack is created to replicate a Stack using a doubly linked list. The
 * top of the stack is at the tail of the doubly linked list and the
 * bottom is at the head.
 *
 * @author Jonathan Tran
 * @since 10/27/2021
 */
public class DLLStack<T> {

    private DoublyLinkedList<T> stack;

    /**
     * This constructor sets the instance variable stack to a new
     * doubly linked list.
     */
    public DLLStack() {
        this.stack = new DoublyLinkedList<T>();
    }

    /**
     * This method checks the size of the stack
     * @return the size of the stack
     */
    public int size() {
        return this.stack.size();
    }

    /**
     * This method checks if the stack is empty
     * @return true if it is empty
     *         false if it is not
     */
    public boolean isEmpty() {
        if (this.stack.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * This method pushes an element into the stack
     * @param data T: an element getting pushed into the stack
     */
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.stack.add(data);
    }

    /**
     * This method pops the element from the stack that is at the
     * top of the stack
     * @return the removed element
     */
    public T pop() {
        if (this.stack.size() == 0) {
            return null;
        }
        return this.stack.remove(this.stack.size() - 1);
    }

    /**
     * This method looks at the element at the top of the stack
     * @return the element at the top of the stack
     */
    public T peek() {
        if (this.stack.size() == 0) {
            return null;
        }
        return this.stack.get(this.stack.size()-1);
    }
}
