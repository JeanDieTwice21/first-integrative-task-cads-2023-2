package util;

public class LinkedList<T>{

    private SingleLinkedNode<T> head;
    private SingleLinkedNode<T> tail;

    public LinkedList(){

        this.head = null;
        this.tail = null;

    }

    public void add(T value){

        SingleLinkedNode<T> newNode = new SingleLinkedNode<>(value);

        if(head == null){

            head = newNode;
            tail =  newNode;

        }
        else{

            tail.setNext(newNode);
            tail =  newNode;

        }


    }


}

