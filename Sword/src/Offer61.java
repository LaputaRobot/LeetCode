import java.util.Arrays;

public class Offer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) zeroCount++;
            else {
                if (i > 0&&nums[i-1]!=0) {
                    if (nums[i]==nums[i-1]) return false;
                    zeroCount -= (nums[i] - nums[i - 1]-1);
                }
                if (zeroCount < 0) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{0,0,8,5,4};
        System.out.println(new Offer61().isStraight(nums));
    }
}
