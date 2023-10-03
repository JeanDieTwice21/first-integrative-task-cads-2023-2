package model;

public class Stack<T>{

    private DoubleLinkedList<T> stack;
    private T top;

    public Stack(){

        this.stack = new DoubleLinkedList<>();
        this.top = null;
    }

    public void push(T value){

        stack.add(value);
        top = value;
    }

    public T pop(){

        DoubleLinkedNode<T> n = stack.search(top);
        T newTop = null;

        if(n != null){

            DoubleLinkedNode<T> p = n.getPrev();

            p.setNext(null);
            newTop = p.getValue();

            n.setPrev(null);
            n.setNext(null);
        }

        return newTop;
    }

    public T top(){

        return top;

    }

    public boolean empty(){

        return  stack.isEmpty();

    }
}
