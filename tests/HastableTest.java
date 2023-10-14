package tests;
import org.junit.Test;
import util.HashTable;
import static org.junit.Assert.*;

public class HastableTest<k,V> {
    
    // Test putting a key-value pair into the hash table and retrieving it with get()
    @Test
    public void test_put_and_get() {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("key", 1);
        assertEquals(Integer.valueOf(1), hashTable.get("key"));
    }

    // Test putting multiple key-value pairs into the hash table and retrieving them with get()
    @Test
    public void test_put_multiple_and_get() {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("key1", 1);
        hashTable.put("key2", 2);
        hashTable.put("key3", 3);
        assertEquals(Integer.valueOf(1), hashTable.get("key1"));
        assertEquals(Integer.valueOf(2), hashTable.get("key2"));
        assertEquals(Integer.valueOf(3), hashTable.get("key3"));
    }

    // Test removing a key-value pair from the hash table with remove()
    @Test
    public void test_remove() {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("key", 1);
        hashTable.remove("key");
        assertNull(hashTable.get("key"));
    }

    // Test putting a null value into the hash table
    @Test
    public void test_put_null_value() {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("key", null);
        assertNull(hashTable.get("key"));
    }

}