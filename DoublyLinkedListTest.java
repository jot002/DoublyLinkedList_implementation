import org.junit.Test;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    int i = 1;
    int j = 2;
    int k = 3;

    @org.junit.jupiter.api.Test
    public void isEmpty() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list1.add(i);
        assertEquals(false,list1.isEmpty());
        list2.add(i);
        list2.add(j);
        assertEquals(false,list2.isEmpty());
        assertEquals(true,list3.isEmpty());
    }

//    @Test (expected = NullPointerException.class)
//    void add1() {
//        list1.add(null);
//    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list1.add(1);
        list1.add(2);
        assertEquals(2, list1.size());
        list2.add(1);
        assertEquals(1, list2.size());
        assertEquals(0, list3.size());
    }

//    @org.junit.jupiter.api.Test
//    void testAdd2() {
//        DoublyLinkedList list1 = new DoublyLinkedList();
//        DoublyLinkedList list2 = new DoublyLinkedList();
//        DoublyLinkedList list3 = new DoublyLinkedList();
//        list1.add(0,1);
//        list1.add(0,2);
//        assertEquals(1, list1.get(1));
//        list2.add(1,1);
//        assertEquals(1, list1.get(1));
//        assertEquals(2, list1.get(0));
//    }

    @org.junit.jupiter.api.Test
    void clear() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list1.add(8);
        list1.add(2);
        assertEquals(2, list1.size());
        list1.clear();
        assertEquals(0, list1.size());
        assertEquals(true,list1.isEmpty());
        list2.add(5);
        assertEquals(false,list2.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list1.add(1);
        assertEquals(true, list1.contains(1));
        assertEquals(false, list1.contains(0));
        list1.add(4);
        assertEquals(false, list1.contains(7));
    }

    @org.junit.jupiter.api.Test
    void get() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        assertEquals(1,list1.get(0));
        assertEquals(2,list1.get(1));
        assertEquals(3,list1.get(2));
        assertEquals(4,list1.get(3));

    }

//    @org.junit.jupiter.api.Test
//    void get() {
//        ERROR  INDEXOUTOFBOUNDS
//
//    }

    @org.junit.jupiter.api.Test
    void testIsEmpty() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list3.add(10);
        assertEquals(false,list3.isEmpty());
        list3.clear();
        assertEquals(true,list3.isEmpty());
        assertEquals(true,list1.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list3.add(10);
        assertEquals(1,list3.size());
        list3.remove(0);
        assertEquals(0,list3.size());
        assertEquals(true,list1.isEmpty());
        list1.add(1);
        list1.add(2);
        list1.add(3);
        assertEquals(3,list1.size());
        list1.remove(1);
        assertEquals(2,list1.size());
    }
//
//    @org.junit.jupiter.api.Test
//    void remove1() {
//        ERROR
//    }

    //
//    @org.junit.jupiter.api.Test
//    void set1() {
//        ERROR
//    }
    @org.junit.jupiter.api.Test
    void set() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list1.add(4);
        list1.set(0,1);
        assertEquals(1,list1.get(0));
        list1.set(0,2);
        assertEquals(2,list1.get(0));
        list1.set(0,3);
        assertEquals(3,list1.get(0));
        list1.add(5);
        assertEquals(5,list1.get(1));
        list1.set(1,231);
        assertEquals(231,list1.get(1));
    }

    @org.junit.jupiter.api.Test
    void size() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list1.add(1);
        list1.add(2);
        assertEquals(2, list1.size());
        list2.add(1);
        assertEquals(1, list2.size());
        assertEquals(0, list3.size());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.add(1);
        String sentence1 = "[(head) -> 1 -> (tail)]";
        assertEquals(sentence1, list1.toString());
        list1.add(2);
        String sentence2 = "[(head) -> 1 -> 2 -> (tail)]";
        assertEquals(sentence2, list1.toString());
        list1.add(3);
        String sentence3 = "[(head) -> 1 -> 2 -> 3 -> (tail)]";
        assertEquals(sentence3, list1.toString());
        list1.add(4);
        String sentence4 = "[(head) -> 1 -> 2 -> 3 -> 4 -> (tail)]";
        assertEquals(sentence4, list1.toString());
    }

    @org.junit.jupiter.api.Test
    void removeMultipleOf() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list1.add(i);
        list1.add(k);
        list1.add(k);
        list1.add(j);
        list1.add(j);
        list1.removeMultipleOf(2);
        assertEquals(2, list1.size());
        list2.add(i);
        list2.add(k);
        list2.removeMultipleOf(2);
        assertEquals(1, list2.size());
        list3.add(i);
        list3.add(k);
        list3.add(i);
        list3.add(k);
        list3.removeMultipleOf(4);
        assertEquals(3, list3.size());
    }

    @org.junit.jupiter.api.Test
    void swapSegment() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3 = new DoublyLinkedList();
        list1.add(i);
        list1.add(j);
        list1.add(j);
        list2.add(k);
        list2.add(k);
        list2.add(k);
        list1.swapSegment(list2, 0);
        assertEquals(3, list1.get(0));
        assertEquals(1, list2.get(0));
        assertEquals(2, list1.get(1));
        assertEquals(3, list2.get(1));
    }
}