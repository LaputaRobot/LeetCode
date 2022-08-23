import java.util.TreeSet;

public class LC217 {
    public boolean containsDuplicate(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        for (int num : nums) {
            if (set.contains(num))return false;
            else set.add(num);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new LC217().containsDuplicate(new int[]{1,3,4,2}));
    }
}
