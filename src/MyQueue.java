public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> queue = new MyLinkedList<>();

    public MyQueue() {
    }

    public MyQueue(MyLinkedList<T> array) {
        this.queue = array;
    }

    public boolean empty() {//Returns whether the queue is empty
        return queue.size() == 0;
    }
    public int size(){//Returns the size of the queue
        return queue.size();
    }
    public  T peek(){//Returns a reference to the front element of the queue
        return queue.getLast();
    }
    public T enqueue(T item){//Adds the element at the end of the queue
        queue.AddLast(item);
        return item;
    }
    public T dequeue(){//Retrieves and deletes the front element of the queue
        T ret = queue.getFirst();
        queue.removeFirst();
        return ret;
    }
    public boolean isEmpty() {
        return queue.size() == 0;
    }
}