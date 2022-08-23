import java.util.Arrays;

public class Offer56 {
    public int[] singleNumbers(int[] nums) {
        int z=nums[0];
        for (int i = 1; i < nums.length; i++) {
            z^=nums[i];
        }
        int m=1;
        while ((z&m)==0){
            m<<=1;
        }
        int x=0,y=0;
        for (int num : nums) {
            if ((num & m) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};
    }
    public int singleNumber1(int[] nums) {
        int res=0;
        return res;
    }
    public static void main(String[] args) {
        int[] nums={1,2,141,2,1,132};
        System.out.println(Arrays.toString(new Offer56().singleNumbers(nums)));
    }
}
