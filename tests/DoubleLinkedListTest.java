package tests;

import util.DoubleLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleLinkedListTest<T> {
    // Searching for an element in the list using search() method
    @Test
    public void test_search_element() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        assertEquals("banana", list.search("banana").getValue());
    }

    // Adding null element to the list using add() method
    @Test
    public void test_add_null_element() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("apple");
        list.add(null);
        list.add("orange");
        assertNull(list.search(null).getValue());
    }

    // Deleting the last element from an empty list using deleteLast() method
    @Test
    public void test_delete_last_element_empty_list() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertNull(list.removeLast());
    }

    // Searching for an element not present in the list using search() method
    @Test
    public void test_search_element_not_present() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        assertNull(list.search("grape"));
    }
}