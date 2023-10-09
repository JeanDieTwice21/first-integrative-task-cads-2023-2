package tests;
import model.Queue;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest<T> {


    // Enqueue and dequeue elements in order
    @Test
    public void test_enqueue_dequeue_order() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
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

    // Enqueue and dequeue multiple elements
    @Test
    public void test_enqueue_dequeue_multiple_elements() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}