package model;

public class DoubleLinkedList<T>{

    private DoubleLinkedNode<T> head;
    private DoubleLinkedNode<T> tail;
    public DoubleLinkedList(){

        this.head = null;
        this.tail = null;
    }

    public void add(T value) {

        DoubleLinkedNode<T> node = new DoubleLinkedNode<>(value);

        if(head == null) {
            this.head = node;
            this.tail = node;
        }
        else {

            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        }
    }

    public DoubleLinkedNode<T> search(T value){

        DoubleLinkedNode<T> toReturn = null;
        boolean flag = false;

        if(head != null){

            DoubleLinkedNode<T> current = head;

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
