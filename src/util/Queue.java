package util;

public class Queue<T>{

    private LinkedList<T> queue;

    public Queue(){

        queue = new LinkedList<>();
    }

    public void enqueue(T value){

        queue.add(value);
    }

    public T dequeue(){

        return queue.deleteFirst();
    }

    public T peek(){

        return queue.getFirst();
    }

    public boolean isEmpty(){

        return queue.isEmpty();

    }
}
