package util;

public class PriorityQueue<T extends Comparable<T>> {

    private DoubleLinkedList<T> q;

    public PriorityQueue(){

        q = new DoubleLinkedList<>();

    }

    public void enqueue(T value) {

        q.add(value);

        int currentI = q.size() - 1;

        while (currentI > 0) {

            int parentI = (currentI - 1) / 2;
            if (q.get(currentI).compareTo(q.get(parentI)) >= 0) {

                break;
            }
            swap(currentI, parentI);
            currentI = parentI;
        }
    }

    public T dequeue(){

        T value = null;
        if(q.isEmpty()){

            value = null;
        }
        
        T minValue = q.getFirst();
        int lastI = q.size() - 1;
        q.set(0, q.get(lastI));
        q.removeLast();
        int currentI = 0;

        while (true) {

            int leftChildIndex = 2 * currentI + 1;
            int rightChildIndex = 2 * currentI + 2;
            int smallestIndex = currentI;

            if (leftChildIndex < q.size() && q.get(leftChildIndex).compareTo(q.get(smallestIndex)) < 0) {
                smallestIndex = leftChildIndex;
            }

            if (rightChildIndex < q.size() && q.get(rightChildIndex).compareTo(q.get(smallestIndex)) < 0) {
                smallestIndex = rightChildIndex;
            }

            if (smallestIndex == currentI) {
                break;
            }

            swap(currentI, smallestIndex);
            currentI = smallestIndex;
        }

        return minValue;

    }

    public T peek(){

        T value = null;

        if(q.isEmpty()){

            value = null;

        }
        else{

            value = q.getFirst();

        }

        return value;
    }

    private void swap(int i, int j){

        T temp = q.get(i);
        q.set(i, q.get(j));
        q.set(j, temp);
    }

    public boolean remove(T value) {

        boolean flag = false;

        int index = -1;

        for (int i = 0; i < q.size(); i++) {
            if (q.get(i).equals(value)) {
                index = i;
                break;
            }
        }

        if (index != -1) {

            q.set(index, q.get(q.size() - 1));
            q.removeLast();


            int currentIndex = index;
            while(true){
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;
                int smallestIndex = currentIndex;

                if (leftChildIndex < q.size() && q.get(leftChildIndex).compareTo(q.get(smallestIndex)) < 0) {
                    smallestIndex = leftChildIndex;
                }

                if (rightChildIndex < q.size() && q.get(rightChildIndex).compareTo(q.get(smallestIndex)) < 0) {
                    smallestIndex = rightChildIndex;
                }

                if (smallestIndex == currentIndex) {
                    break;
                }

                swap(currentIndex, smallestIndex);
                currentIndex = smallestIndex;
            }

            flag = true;
        }

        return flag;

    }

    @Override
    public String toString(){


        return q.toString();
    }



}