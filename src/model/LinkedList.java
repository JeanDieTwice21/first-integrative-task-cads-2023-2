package model;

public class LinkedList<T>{

    private SingleLinkedNode<T> head;
    private SingleLinkedNode<T> tail;

    private T lastAdded;

    public LinkedList(){

        this.head = null;
        this.tail = null;
        this.lastAdded = null;

    }

    public void add(T value){

        lastAdded = value;
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

            SingleLinkedNode<T> newHead = head.getNext();

           deleted = head.getValue();
           head = null;

           head = newHead;

        }

        return deleted;
    }

    public T getFirst(){

        return head.getValue();

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

    @Override
    public String toString(){

        String msg = "";

        if(isEmpty()){

            msg = "No elements.";

        }
        else{

            SingleLinkedNode<T> current = head;

            while(current != null){


                msg += current.getValue().toString() + "\n";

                current = current.getNext();
            }
        }

        return msg;
    }

    public boolean isEmpty(){

        return head == null;
    }


}

