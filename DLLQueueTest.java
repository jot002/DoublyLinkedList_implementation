import org.junit.Test;

import static org.junit.Assert.*;

public class DLLQueueTest {

    @Test
    public void size() {
        DLLQueue queue1 = new DLLQueue();
        DLLQueue queue2 = new DLLQueue();
        DLLQueue queue3 = new DLLQueue();
        int i = 0;
        queue1.enqueue(i);
        queue2.enqueue(i);
        queue2.enqueue(i);
        queue2.enqueue(i);
        assertEquals(1, queue1.size());
        assertEquals(3, queue2.size());
        assertEquals(0, queue3.size());
        queue2.dequeue();
        assertEquals(2, queue2.size());
    }

    @Test
    public void isEmpty() {
        DLLQueue queue1 = new DLLQueue();
        DLLQueue queue2 = new DLLQueue();
        DLLQueue queue3 = new DLLQueue();
        int i = 0;
        queue1.enqueue(i);
        queue2.enqueue(i);
        queue2.enqueue(i);
        queue2.enqueue(i);
        assertEquals(false, queue1.isEmpty());
        assertEquals(false, queue2.isEmpty());
        assertEquals(true, queue3.isEmpty());
        queue2.dequeue();
        assertEquals(false, queue2.isEmpty());
        queue2.dequeue();
        queue2.dequeue();
        assertEquals(true, queue2.isEmpty());
    }

    @Test
    public void enqueue() {
        DLLQueue queue1 = new DLLQueue();
        DLLQueue queue2 = new DLLQueue();
        DLLQueue queue3 = new DLLQueue();
        int i = 0;
        queue1.enqueue(i);
        queue2.enqueue(i);
        queue2.enqueue(i);
        queue2.enqueue(i);
        assertEquals(1, queue1.size());
        assertEquals(3, queue2.size());
        assertEquals(0, queue3.size());
        queue2.dequeue();
        assertEquals(2, queue2.size());
    }

    @Test
    public void dequeue() {
        DLLQueue queue1 = new DLLQueue();
        DLLQueue queue2 = new DLLQueue();
        DLLQueue queue3 = new DLLQueue();
        int i = 0;
        queue1.enqueue(i);
        queue2.enqueue(i);
        queue2.enqueue(i);
        queue2.enqueue(i);
        assertEquals(1, queue1.size());
        assertEquals(3, queue2.size());
        assertEquals(0, queue3.size());
        queue2.dequeue();
        assertEquals(2, queue2.size());
        queue2.dequeue();
        queue2.dequeue();
        assertEquals(0, queue2.size());
        assertEquals(null, queue2.dequeue());
        assertEquals(null, queue3.dequeue());
    }

    @Test
    public void peek() {
        DLLQueue queue1 = new DLLQueue();
        DLLQueue queue2 = new DLLQueue();
        DLLQueue queue3 = new DLLQueue();
        int i = 0;
        int j = 4;
        int k = 9;
        queue1.enqueue(i);
        queue2.enqueue(i);
        assertEquals(0, queue2.peek());
        queue2.enqueue(i);
        assertEquals(0, queue2.peek());
        queue2.enqueue(i);
        assertEquals(0, queue1.peek());
        assertEquals(0, queue2.peek());
        queue2.dequeue();
        assertEquals(null, queue3.peek());
    }
}