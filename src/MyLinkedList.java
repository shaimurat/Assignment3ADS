import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>>{
    private MyNode<T> head;//start of node
    private MyNode<T> tail;//end of node
    private int size = 0;
    private static class MyNode<E>{
        E data;//data in node
        MyNode<E> next;//moving to next node
        MyNode<E> prev;//moving to previous node
        MyNode(E data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        MyNode(){
            this.data = null;
            this.next = null;
            this.prev = null;
        }
    }
    public MyLinkedList(){
        head = null;
        tail = null;
    }
    public void indexCheck(int index){
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }
    public void add(T item) {//adding items
        MyNode<T> newItem = new MyNode<>(item);
        if(head == null){
            head = tail = newItem;
        }
        else {
            tail.next = newItem;
            tail = newItem;
        }
        size++;
    }


    public void set(int index, T item) {//changing item of node under this index
        indexCheck(index);
        MyNode<T> newItem = new MyNode<>(item);
        MyNode current = head;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        current.data = newItem.data;
    }

    public void add(int index, T item) {//add item to this index
        indexCheck(index);
        MyNode<T> newItem = new MyNode<T>(item);
        if(index == 0){
            newItem.next = head;
            head = newItem;
        }
        else if (index == size){
            tail.next = newItem;
            tail = newItem;
        }
        else{
            MyNode<T> current = head;
            for(int i=0;i<index-1;i++){
                current = current.next;
            }
            newItem.next = current.next;
            current.next = newItem;
        }
        size++;
    }


    public void AddFirst(T item) {
        add(0, item);
    }//add item to the first ind


    public void AddLast(T item) {
        add(size, item);
    }//add item to last index


    public T get(int index) {//get item under this index
        indexCheck(index);
        MyNode<T> current = head;
        for(int i = 0;i<index;i++){
            current = current.next;
        }
        return current.data;
    }


    public T getFirst() {
        return head.data;
    }


    public T getLast() {
        return tail.data;
    }


    public void remove(int index) {//removing items
        indexCheck(index);
        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            MyNode current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        else {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    public void removeFirst() {
        remove(0);
    }//remove first item


    public void removeLast() {
        remove(size-1);
    }//remove last item


    public void sort() {//sorting LinkedList in ascending order
        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i; j != null; j = j.next) {
                if (((Comparable)i.data).compareTo(j.data) > 0) {
                    Object current = i.data;
                    i.data = j.data;
                    j.data = current;
                }
            }
        }
    }


    public int indexOf(Object object) {//returns index of this item
        MyNode current = head;
        int ind = 0;
        while (current.data != object){
            if(ind == size - 1){
                break;
            }
            current = current.next;
            ind++;
        }
        return ind++;
    }


    public int lastIndexOf(Object object) {//return last index of object
        MyNode current = head;
        int ind = 0;
        int saveInd=-999;
        while (current != null){
            if(current.data == object){
                saveInd = ind;
            }
            current = current.next;
            ind++;
        }
        return saveInd;
    }


    public boolean exists(Object object) {//returns true if object is in LinkedList
        MyNode current = head;
        while (current != null){
            if(current.data == object){
                return true;
            }
            current= current.next;
        }
        return false;
    }

    public Object[] toArray() {//returns array of linked list
        MyNode<T> current = head;
        Object[] array = new Object[size];
        for (int i=0;i<size;i++){
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    public void clear() {//deletes everything from linked list
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }//returns size of linked list

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T> {
        private MyNode<T> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T nextItem = current.data;
            current = current.next;
            return nextItem;
        }
    }
}
