package util;

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

        if(top == null){

            return null;
        }
        return stack.removeLast();

    }

    public T top(){

        return top;

    }

    public boolean empty(){

        return  stack.isEmpty();

    }
}
