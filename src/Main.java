import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {

        //MyHashTable<TestClass , Student> table =  new MyHashTable<TestClass , Student>();
        //for(int i = 0;i < 10000;i++){
           // table.put(new TestClass(ranStd(5)), new Student(ranStd(6),ranStd(7)));
        //}
       // for(int i = 0;i < table.getM();i++){
           // System.out.println(table.numOfElem(i));
        bstTest();
        }
    public static String ranStd(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < length ; i++) {
            result.append(chars.charAt(random.nextInt(chars.length())));
        }
        return result.toString();
    }
    public static void bstTest(){
        MyBST<Integer,String> bst = new MyBST<>();
        bst.put(10,"1000");
        bst.put(12,"10001");
        bst.put(4,"1000");
        bst.put(14,"1000");
        bst.put(12,"001");
        bst.delete(12);
        System.out.println(bst.getV(12));
        System.out.println(bst.getSize());
    }
}
