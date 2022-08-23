import java.util.ArrayList;
import java.util.List;

public class LC163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res=new ArrayList<>();
        if (nums.length==0) {
            if (lower<upper)
                res.add(""+lower+"->"+upper);
            else res.add(""+lower);
            return res;
        }
        if (nums[0]>lower){
            if (lower+1==nums[0]) res.add(""+lower);
            else {
                res.add(""+lower+"->"+(nums[0]-1));
            }
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]+1<nums[i+1]){
                if (nums[i]+2==nums[i+1]) res.add(""+(nums[i]+1));
                else {
                    res.add(""+(nums[i]+1)+"->"+(nums[i+1]-1));
                }
            }
        }
        if (nums[nums.length-1]<upper) {
            if (nums[nums.length-1]+1==upper) res.add(""+upper);
            else {
                res.add(""+(nums[nums.length-1]+1)+"->"+upper);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{};
        System.out.println(new LC163().findMissingRanges(nums,1,1));
    }
}
