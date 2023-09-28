package util;

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

}
