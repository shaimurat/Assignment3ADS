import com.sun.source.tree.Tree;

import java.util.Iterator;

public class MyBST<K extends Comparable<K>, V> {
    public TreeNode root;
    private int size = 0;
    private class TreeNode{
        private K key;
        private V value;
        private int length = 1;
        private TreeNode right, left;
        public TreeNode(K key, V value){
            this.key = key;
            this.value = value  ;
        }
    }
    public MyBST(){
        root = null;
    }
    public void put(K key, V value) {
        if (root == null) {
            root = new TreeNode(key, value);
            size++;
            return;
        }
        TreeNode current = root;
        while (true) {
            if (key.compareTo(current.key) < 0) {
                if (current.left != null) current = current.left;
                else {
                    current.left = new TreeNode(key, value);
                    size++;
                    return;
                }
            }
            else if (key.compareTo(current.key) > 0) {
                if (current.right != null) current = current.right;
                else {
                    current.right = new TreeNode(key, value);
                    size++;
                    return;
                }
            }
            else {
                current.value = value;
                return;
            }
        }

    }
    public V getV(K key){
        TreeNode newNode = root;
        while(newNode!=null){
            if(newNode.left!=null){
            if(newNode.left.key.equals(key)){
                return newNode.left.value;
            }}
            if(newNode.left!=null){
            if(newNode.right.key.equals(key)){
                return newNode.right.value;
            }}
            if(key.compareTo(newNode.key)>0){
                newNode = newNode.right;
            }
            else if (key.compareTo(newNode.key)<0) {
                newNode = newNode.left;
            }
        }
        return null;
    }
    public void delete(K key) {
        if (root == null) return;
        TreeNode cur = root;
        while(cur != null){
            if(key.compareTo(cur.key)>0){
                cur = cur.right;
            }
            else if (key.compareTo(cur.key)<0) {
                cur = cur.left;
            }
            else {
                if(cur.right == null || cur.left == null){
                    cur = null;
                    size--;
                    return;
                } else if (cur.right != null) {
                    cur = cur.right;
                    size--;
                    return;
                } else if (cur.left != null) {
                    cur = cur.left;
                    size--;
                    return;
                }
                else {
                    TreeNode temp = cur;
                    TreeNode parent = temp;
                    temp = temp.right;
                    while (temp.left != null){
                        parent = temp;
                        temp = temp.left;
                    }
                    cur.value = temp.value;
                    cur.key = temp.key;
                    parent.left = null;
                    size--;
                    return;
                }
            }
        }
    }
    public int getSize() {
        return size;
    }
    private class BSTIterator implements Iterator<K> {
        private MyQueue<K> queue = new MyQueue<>();
        public BSTIterator() {
            inOrder(root);
        }
        private void inOrder(TreeNode node) {
            if(node == null) return;
            inOrder(node.left);
            queue.enqueue(node.key);
            inOrder(node.right);
        }
        public boolean hasNext() {
            return !queue.isEmpty();
        }
        public K next() {
            return queue.dequeue();
        }

    }
}
