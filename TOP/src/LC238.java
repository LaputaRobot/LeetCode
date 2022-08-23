import java.util.Arrays;

public class LC238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        ans[nums.length-1]=nums[nums.length-1];
        for (int i = nums.length-2; i >0 ; i--) {
            ans[i]=ans[i+1]*nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i]*=nums[i-1];
        }
        ans[0]=ans[1];
        for (int i = 1; i < nums.length-1; i++) {
            ans[i]=ans[i+1]*nums[i-1];
        }
        ans[nums.length-1]=nums[nums.length-2];
        return ans;
    }

    public static void main(String[] args) {

        int[] nums=new int[]{-1,1};
        System.out.println(Arrays.toString(new LC238().productExceptSelf(nums)));
    }
}
