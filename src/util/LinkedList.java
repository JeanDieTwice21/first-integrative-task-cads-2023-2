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

    public T deleteFirst(){

        T deleted = null;

        if(head != null){

           deleted = head.getValue();

            SingleLinkedNode<T> newHead = head.getNext();

            head = newHead;

        }

        return deleted;
    }

    public T getFirst(){

        T first = head.getValue();

        return first;
    }

    public SingleLinkedNode<T> search(T value){

        SingleLinkedNode<T> toReturn = null;
        boolean flag = false;

        if(head != null){

            SingleLinkedNode<T> current = head;

            while(current.getNext() != null && !flag){

                if(current.getValue() == value){

                    toReturn = current;
                    flag = true;
                }

                current = current.getNext();
            }
        }

        return toReturn;

    }

    public boolean isEmpty(){

        return head == null;
    }


}

