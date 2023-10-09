package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import model.LinkedList;
import model.SingleLinkedNode;

public class LinkedListTest<T>{

    // Add elements to the list and verify they were added correctly.
    @Test
    public void test_add_elements() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
    
        assertEquals("1\n2\n3\n", list.toString());
    
    }

    // Delete the first element from an empty list and verify null is returned.
    @Test
    public void test_delete_first_element_empty_list() {
        LinkedList<Integer> list = new LinkedList<>();
    
        Integer deleted = list.deleteFirst();
    
        assertNull(deleted);
    }

    // Search for an element that does not exist in the list and verify null is returned.
    @Test
    public void test_search_non_existing_element() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    
        SingleLinkedNode<Integer> node = list.search(4);
    
        assertNull(node);
    }

        // Search for an existing element in the list and verify it is returned correctly.
        @Test
        public void test_search_existing_element() {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(1);
            list.add(2);
            list.add(3);
    
            SingleLinkedNode<Integer> node = list.search(2);
    
            assertNotNull(node);
            assertEquals(2, node.getValue().intValue());
        }


}