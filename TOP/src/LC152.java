import java.util.Arrays;
import java.util.Random;

public class LC152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        Random random=new Random();
        int len=random.nextInt(20);
        int[] nums=new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=random.nextInt(20)-10;
        }
        nums=new int[]{2,2,-1,2,2,-2,2,2,-3,2,2};
//        nums=new int[]{1,1,-1,1,1,-2,1,1,-3,1,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(new LC152().maxProduct(nums));
    }
}
