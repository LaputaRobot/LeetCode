import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class RBTree {
    public static void main(String[] args) {
        HashMap hashMap=new HashMap();
        TreeSet<Integer> treeSet=new TreeSet<>();
        treeSet.add(1);
        treeSet.add(12);
        treeSet.add(3);
        treeSet.add(14);
        System.out.println(Arrays.toString(treeSet.toArray()));
    }
}
