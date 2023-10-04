package model;

public class SingleLinkedNode<T>{

    private SingleLinkedNode<T> next;
    private T value;
    public SingleLinkedNode(T value){

        this.next = null;
        this.value = value;


    }

    public SingleLinkedNode<T> getNext(){

        return next;

    }

    public T getValue(){

        return value;
    }

    public void setValue(T newValue){

        value = newValue;

    }

    public void setNext(SingleLinkedNode<T> newNext){

        next = newNext;
    }
}
