import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if (nums.length<3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) return res;
            while (i>0&&i<nums.length-1&&nums[i]==nums[i-1]) i++;
            int l=i+1,r=nums.length-1;
            while (l<r) {
                int sum=nums[i] + nums[l] + nums[r];
                if ( sum== 0) {
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (r>0&&nums[r] == nums[r - 1]) r--;
                    while (l<nums.length-1&&nums[l] == nums[l + 1]) l++;
                    r--;
                    l++;
                }
                else if (sum > 0)r--;
                else  l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={0,0,0};
        System.out.println(new LC15().threeSum(nums));
    }
}
