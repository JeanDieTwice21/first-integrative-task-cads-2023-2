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

        return stack.deleteLast();

    }

    public T top(){

        return top;

    }

    public boolean empty(){

        return  stack.isEmpty();

    }
}
