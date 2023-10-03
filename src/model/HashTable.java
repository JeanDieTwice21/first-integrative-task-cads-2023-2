package model;

public class HashTable<K, V>{

    private HTNode<K,V>[] table;
    private int size;

    public HashTable(int size){

        table = new HTNode[size];
        this.size = 0;


    }

    private int hash(K key){

        return key.hashCode() % size;

    }

    public void put(K key, V value){

        int index = hash(key);
        table[index] = new HTNode<>(key, value);

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
        for(int i = 0; i < size; i++){

            if(table[i] != null){

                msg += "Key: " + table[i].getKey() + "\n Task: " + table[i].getValue().toString() + "\n";
            }
        }

        return msg;
    }
}
