package tests;
import util.PriorityQueue;
import org.junit.Test;
import static org.junit.Assert.*;

public class PriorityQueueTest<T extends Comparable<T>> {

    // enqueue elements in ascending order
    @Test
    public void test_enqueue_ascending_order() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, (int) queue.dequeue());
        assertEquals(3, (int) queue.dequeue());
    }

    // enqueue elements in descending order
    @Test
    public void test_enqueue_descending_order() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, (int) queue.dequeue());
        assertEquals(3, (int) queue.dequeue());
    }

    // enqueue elements in random order
    @Test
    public void test_enqueue_random_order() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(3);
        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, (int) queue.dequeue());
        assertEquals(3, (int) queue.dequeue());
    }

    // enqueue null element
    @Test
    public void test_enqueue_null_element() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(null);
        assertNull(queue.dequeue());
    }

    
}