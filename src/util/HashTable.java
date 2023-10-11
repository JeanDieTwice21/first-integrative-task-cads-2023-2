package util;

public class HashTable<K, V>{

    private HTNode<K,V>[] table;
    private int capacity;
    private int size;

    public HashTable(int capacity){

        table = new HTNode[capacity];
        this.capacity = capacity;
        this.size = 0;

    }

    public int getSize(){

        return size;
    }

    private int hash(K key){

        return key.hashCode() % capacity;

    }

    public void put(K key, V value){

        int index = hash(key);
        table[index] = new HTNode<>(key, value);
        size++;

    }

    public V get(K key) {

        V value = null;
        int i = hash(key);
        if(table[i] != null && table[i].getKey().equals(key)){

            value = table[i].getValue();
        }

        return value;
    }

    public void remove(K key){

        int i = hash(key);
        if(table[i] != null && table[i].getKey().equals(key)){

            table[i] = null;
        }
    }

    @Override
    public String toString(){

        String msg = " ";
        for(int i = 0; i < capacity; i++){

            if(table[i] != null){

                msg += "Key: " + table[i].getKey() + "\n" + table[i].getValue() + "\n\n";
            }
        }

        if(msg.equals(" ")){

            msg = "No elements";
        }

        return msg;
    }
}
