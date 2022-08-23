import java.util.Arrays;

public class Offer21 {
    public int[] exchange(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<right){
            while (nums[left]%2==1) {
                if (left==right) return nums;
                    left++;
            }
            while (nums[right]%2==0) {
                if (right==left) return nums;
                right--;
            }
            int tmp=nums[left];
            nums[left]=nums[right];
            nums[right]=tmp;
            left++;
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,5,7,3,18,0,1,5,8,74,57,5,1,431,4};
        System.out.println(Arrays.toString(new Offer21().exchange(nums)));
    }
}
