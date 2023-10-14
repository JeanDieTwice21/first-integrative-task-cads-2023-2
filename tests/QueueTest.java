package tests;
import util.Queue;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest<T> {


    // Enqueue and dequeue the same element multiple times
    @Test
    public void test_enqueue_dequeue_same_element_multiple_times() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertNull(queue.dequeue());
        queue.enqueue(1);
        assertEquals(Integer.valueOf(1), queue.dequeue());
    }

    // Peek returns first element without removing it
    @Test
    public void test_peek() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(Integer.valueOf(1), queue.peek());
        assertEquals(Integer.valueOf(1), queue.peek());
    }

    // Check if queue is empty after enqueue and dequeue
    @Test
    public void test_isEmpty_after_enqueue_dequeue() {
        Queue<Integer> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    // Test that peek works correctly when the queue contains only one element
    @Test
    public void test_peek_works_with_one_element() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        assertEquals(Integer.valueOf(1), queue.peek());
    }
}