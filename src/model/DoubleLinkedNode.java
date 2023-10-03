package model;

public class DoubleLinkedNode<T>{

    private DoubleLinkedNode<T> next;
    private DoubleLinkedNode<T> prev;

    private T value;

    public DoubleLinkedNode(T value){

        this.next = null;
        this.prev = null;
        this.value = value;
    }

    public DoubleLinkedNode<T> getNext(){

        return next;

    }

    public DoubleLinkedNode<T> getPrev(){

        return prev;
    }

    public void setNext(DoubleLinkedNode<T> newNext){

        next = newNext;
    }

    public void setPrev(DoubleLinkedNode<T> newPrev){

        prev = newPrev;
    }

    public T getValue(){

        return value;

    }

    public void setValue(T newValue){

        value = newValue;
    }
}
