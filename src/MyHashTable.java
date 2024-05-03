public class MyHashTable<K,V> {
    private HashNode<K,V>[] chain;
    private int m = 11;
    private Double loadFactor = 0.75;
    private int size = 0;
    private class HashNode<K, V>{
        private K key;
        private V value;
        HashNode<K,V> next;
        public HashNode(){}
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "HashNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public MyHashTable(){
        chain = new HashNode[m];
    }
    public MyHashTable(int initCap){
        this.m = (int) (initCap * loadFactor);
        chain = new HashNode[m];
    }
    public int numOfElem(int index){
        int count = 0;
        HashNode<K, V> temp = chain[index];
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public void increaseCapacity() {
        if((double) size / m > loadFactor){
            int oldcap = m;
            m = m * 2;
            HashNode<K , V>[] temp = chain;
            chain = new HashNode[m];
            for (int i = 0;i < oldcap;i++){
                if(temp[i]!=null){
                    HashNode<K,V> node = temp[i];
                    while(node != null){
                        HashNode<K , V> newNode = new HashNode<>(node.key , node.value);
                        int ind = hash(node.key);
                        newNode.next = chain[ind];
                        chain[ind] = newNode;
                        node = node.next;
                    }
                }
            }
        }
    }
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    public void put(K key, V value){
        increaseCapacity();
        int ind = hash(key);
        HashNode<K , V> newNode = new HashNode<>(key , value);
        newNode.next = chain[ind];
        chain[ind] = newNode;
        size++;
    }
    public V get(K key){
        int ind = hash(key);
        HashNode<K, V> node = chain[ind];
        while(node!=null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public void remove(K key){
        int ind = hash(key);
        HashNode<K, V> node = chain[ind];
        HashNode<K, V> newNode = new HashNode<>();
        while(node != null){
            if(node.key.equals(key)){
                node = node.next;
                continue;
            }
            newNode = node;
            node = node.next;
        }
        chain[ind] = newNode;
        size--;
    }
    public boolean contains(V value) {
        for(int i=0;i<m;i++){
            HashNode<K, V> node = chain[i];
            while(node!=null){
                if(node.value == value){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
    public K getKey(V value) {
        for(int i=0;i<m;i++){
            HashNode<K, V> node = chain[i];
            while(node!=null){
                if(node.value == value){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
    public int getM() {
        return m;
    }
}
