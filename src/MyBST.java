public class MyBST<K extends Comparable<K>, V> {
    TreeNode root;
    private int size;
    private class TreeNode{
        private K key;
        private V value;
        private TreeNode right, left;
        public TreeNode(K key, V value){
            this.key = key;
            this.value = value  ;
        }
    }
    public void put(K key, V value){
        if(size == 0){
            root.key = key;
            root.value = value;
        }
        else{
            TreeNode newNode = root;
            while(newNode != null){
                if(key.compareTo(newNode.key)>0){
                    newNode = newNode.right;
                }
                else if (key.compareTo(newNode.key)<0) {
                    newNode = newNode.left;
                }
            }
            newNode.key = key;
            newNode.value = value;
        }
        size++;
    }
    public V getV(K key){
        TreeNode newNode = root;
        while(newNode!=null){
            if(newNode.key.equals(key)){
                return newNode.value;
            }
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
        TreeNode newNode = root;
        while(newNode!=null){
            if(newNode.key.equals(key)){
                if(newNode.right == null & newNode.left == null){newNode=null;}
                else if (newNode.right == null) {
                    TreeNode temp = newNode.left;
                    newNode.left = newNode;
                    newNode = temp;
                }
                else if (newNode.left == null) {
                    TreeNode temp = newNode.left;
                    newNode.left = newNode;
                    newNode = temp;
                }
            }
            if(key.compareTo(newNode.key)>0){
                newNode = newNode.right;
            }
            else if (key.compareTo(newNode.key)<0) {
                newNode = newNode.left;
            }
        }
    }
}
