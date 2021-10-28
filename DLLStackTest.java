import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;

class DLLStackTest {

    @Before
    public void setup(){
        DLLStack stack1 = new DLLStack();
        DLLStack stack2 = new DLLStack();
        DLLStack stack3 = new DLLStack();
    }

    @org.junit.jupiter.api.Test
    void size() {
        DLLStack stack1 = new DLLStack();
        DLLStack stack2 = new DLLStack();
        DLLStack stack3 = new DLLStack();
        int i = 0;
        stack1.push(i);
        stack2.push(i);
        stack2.push(i);
        stack2.push(i);
        assertEquals(new Integer(1), stack1.size());
        assertEquals(new Integer(3), stack2.size());
        assertEquals(new Integer(0), stack3.size());
        stack2.pop();
        assertEquals(new Integer(2), stack2.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
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

    @org.junit.jupiter.api.Test
    void push() {
        DLLStack stack1 = new DLLStack();
        DLLStack stack2 = new DLLStack();
        DLLStack stack3 = new DLLStack();
        int i = 0;
        stack1.push(i);
        stack2.push(i);
        stack2.push(i);
        stack2.push(i);
        assertEquals(new Integer(1), stack1.size());
        assertEquals(new Integer(3), stack2.size());
        assertEquals(new Integer(0), stack3.size());
        stack2.pop();
        assertEquals(new Integer(2), stack2.size());
    }

    @org.junit.jupiter.api.Test
    void pop() {
        DLLStack stack1 = new DLLStack();
        DLLStack stack2 = new DLLStack();
        DLLStack stack3 = new DLLStack();
        int i = 0;
        stack1.push(i);
        stack2.push(i);
        stack2.push(i);
        stack2.push(i);
        assertEquals(new Integer(1), stack1.size());
        assertEquals(new Integer(3), stack2.size());
        assertEquals(new Integer(0), stack3.size());
        stack2.pop();
        assertEquals(new Integer(2), stack2.size());
        stack2.pop();
        assertEquals(new Integer(1), stack2.size());
        stack2.pop();
        assertEquals(new Integer(0), stack2.size());
        stack3.pop();
        assertEquals(null, stack3.pop());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        DLLStack stack1 = new DLLStack();
        DLLStack stack2 = new DLLStack();
        DLLStack stack3 = new DLLStack();
        int i = 0;
        int j = 4;
        int k = 9;
        stack1.push(i);
        stack2.push(i);
        assertEquals(new Integer(0), stack2.peek());
        stack2.push(j);
        assertEquals(new Integer(4), stack2.peek());
        stack2.push(k);
        assertEquals(new Integer(9), stack2.peek());
        assertEquals(new Integer(0), stack1.peek());
        assertEquals(null, stack3.peek());
        stack2.pop();
        assertEquals(new Integer(4), stack2.peek());
    }
}