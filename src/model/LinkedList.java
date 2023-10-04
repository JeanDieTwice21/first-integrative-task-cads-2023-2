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

        SingleLinkedNode<T> newNode = new SingleLinkedNode<>(value);

        if(head == null){

            head = newNode;
            tail =  newNode;

        }
        else{

            tail.setNext(newNode);
            tail =  newNode;

        }

        lastAdded = value;

    }

    public void delete(T value){

        boolean flag = false;

        if(head != null){

            SingleLinkedNode<T> current = head;
            SingleLinkedNode<T> previous = null;

            while(current.getNext() != null && !flag){

                if((current.getValue().equals(value))){

                    if(previous == null){

                        head = current.getNext();
                    }
                    else{

                        previous.setNext(current.getNext());
                    }

                    flag = true;
                }
                else{
                    previous = current;
                    current = current.getNext();
                }
            }
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

