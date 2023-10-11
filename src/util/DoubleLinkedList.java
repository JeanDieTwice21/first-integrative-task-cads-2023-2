package util;

public class DoubleLinkedList<T>{

    private DoubleLinkedNode<T> head;
    private DoubleLinkedNode<T> tail;
    private int size;
    public DoubleLinkedList(){

        this.head = null;
        this.tail = null;
        size = 0;

    }

    public T removeLast(){

        T val = null;

        if(isEmpty()){

            val = null;

        }

        if(size == 1){

            val = head.getValue();
            head = null;
            tail = null;

        }
        else{

            val = tail.getValue();
            DoubleLinkedNode<T> newTail = tail.getPrev();
            newTail.setNext(null);

            tail = newTail;
        }

        size--;

        return val;
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

        size++;
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

    public T get(int index) {

        T value = null;

        if (index < 0 || index >= size) {

            value = null;
        }
        else{

            DoubleLinkedNode<T> n = getNodeAtIndex(index);

            value = n.getValue();

        }
        return value;
    }

    public T getFirst(){

        T value = null;

        if(head != null){

            value = head.getValue();
        }

        return value;
    }

    public boolean set(int index, T newValue) {

        boolean flag = false;

        if (index < 0 || index >= size) {

            flag = false;

        } else {

            DoubleLinkedNode<T> c = getNodeAtIndex(index);
            c.setValue(newValue);
            flag = true;
        }

        return flag;
    }

    private DoubleLinkedNode<T> getNodeAtIndex(int i){

        DoubleLinkedNode<T> nodeAtI = null;
        DoubleLinkedNode<T> c = null;

        if(i < 0 || i >= size){

            nodeAtI = null;
        }

        if(i <= size/2){

            c = head;
            for(int j = 0; j < i; j++){

                c = c.getNext();
            }
        }
        else{

            c = tail;
            for(int k = size - 1; k > i; k--){

                c = c.getPrev();
            }
        }

        return c;
    }
    public boolean isEmpty(){

        return head == null;
    }

    public int size(){

        return size;
    }




    @Override
    public String toString(){

        String msg = " ";

        if(isEmpty()){

            msg = "No elements.";
        }

        DoubleLinkedNode<T> current = head;

        while(current != null){

            msg += current.getValue().toString() + "\n";

            current = current.getNext();
        }

        return msg;
    }

}
