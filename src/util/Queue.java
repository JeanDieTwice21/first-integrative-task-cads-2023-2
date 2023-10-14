package util;


public class Queue<T>{

    private DoubleLinkedList<T> queue;


    public Queue(){

        queue = new DoubleLinkedList<>();
    }

    public void enqueue(T value){

        queue.add(value);

    }

    public T dequeue(){

        return queue.removeLast();
    }


    public T peek(){

        return queue.getFirst();
    }

    public boolean isEmpty(){

        return queue.isEmpty();

    }



    @Override
    public String toString(){

        return queue.toString();
    }
}
