import org.junit.Test;

import static org.junit.Assert.*;

public class DLLStackTest {

    @Test
    public void size() {
        DLLStack stack1 = new DLLStack();
        DLLStack stack2 = new DLLStack();
        DLLStack stack3 = new DLLStack();
        int i = 0;
        stack1.push(i);
        stack2.push(i);
        stack2.push(i);
        stack2.push(i);
        assertEquals(1, stack1.size());
        assertEquals(3, stack2.size());
        assertEquals(0, stack3.size());
        stack2.pop();
        assertEquals(2, stack2.size());
    }

    @Test
    public void isEmpty() {
        DLLStack stack1 = new DLLStack();
        DLLStack stack2 = new DLLStack();
        DLLStack stack3 = new DLLStack();
        int i = 0;
        stack1.push(i);
        stack2.push(i);
        stack2.push(i);
        assertEquals(false, stack1.isEmpty());
        assertEquals(false, stack2.isEmpty());
        assertEquals(true, stack3.isEmpty());
        stack2.pop();
        stack2.pop();
        assertEquals(true, stack2.isEmpty());
    }

    @Test
    public void push() {
        DLLStack stack1 = new DLLStack();
        DLLStack stack2 = new DLLStack();
        DLLStack stack3 = new DLLStack();
        int i = 0;
        stack1.push(i);
        stack2.push(i);
        stack2.push(i);
        stack2.push(i);
        assertEquals(1, stack1.size());
        assertEquals(3, stack2.size());
        assertEquals(0, stack3.size());
        stack2.pop();
        assertEquals(2, stack2.size());
    }

    @Test
    public void pop() {
        DLLStack stack1 = new DLLStack();
        DLLStack stack2 = new DLLStack();
        DLLStack stack3 = new DLLStack();
        int i = 0;
        stack1.push(i);
        stack2.push(i);
        stack2.push(i);
        stack2.push(i);
        assertEquals(1, stack1.size());
        assertEquals(3, stack2.size());
        assertEquals(0, stack3.size());
        stack2.pop();
        assertEquals(2, stack2.size());
        stack2.pop();
        assertEquals(1, stack2.size());
        stack2.pop();
        assertEquals(0, stack2.size());
        stack3.pop();
        assertEquals(null, stack3.pop());
    }

    @Test
    public void peek() {
        DLLStack stack1 = new DLLStack();
        DLLStack stack2 = new DLLStack();
        DLLStack stack3 = new DLLStack();
        int i = 0;
        int j = 4;
        int k = 9;
        stack1.push(i);
        stack2.push(i);
        assertEquals(0, stack2.peek());
        stack2.push(j);
        assertEquals(4, stack2.peek());
        stack2.push(k);
        assertEquals(9, stack2.peek());
        assertEquals(0, stack1.peek());
        assertEquals(null, stack3.peek());
        stack2.pop();
        assertEquals(4, stack2.peek());
    }
}