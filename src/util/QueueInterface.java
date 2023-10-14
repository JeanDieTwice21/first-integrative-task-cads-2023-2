package util;

public interface QueueInterface<T> {


    boolean isEmpty();
    int size();
    T getFirst();
    T getLast();
    void add(T value);
    void removeFirst();
    void removeLast();
    boolean contains(T value);
    boolean remove(T value);
    void clear();


}
