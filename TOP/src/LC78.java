import java.util.ArrayList;
import java.util.List;

public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        l2.add(nums[0]);
        res.add(l1);
        res.add(l2);
        helper(res,nums,1);
        return res;
    }
    public void helper(List<List<Integer>> res,int[] nums,int index){
        if (index==nums.length) return;
        else {
            int len=res.size();
            for (int i=0;i<len;i++) {
                List<Integer> newL=new ArrayList<>(res.get(i));
                newL.add(nums[index]);
                res.add(newL);
            }
        }
        helper(res,nums,++index);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(new LC78().subsets(nums));
    }
}
