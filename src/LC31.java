import java.util.Arrays;

public class LC31 {
    public void nextPermutation(int[] nums) {
        int start=nums.length-1;
        while (start>0){
            if (nums[start-1]<nums[start]) break;
            start--;
        }
        if (start>0) {
            int exIndex=getNextBigNum(nums,start-1);
            int temp=nums[exIndex];
            nums[exIndex]=nums[start-1];
            nums[start-1]=temp;
        }
        int left=start,right=nums.length-1;
        while (left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;right--;
        }
    }
    public int getNextBigNum(int nums[],int index){
        for (int i = nums.length-1; i > index; i--) {
            if (nums[i]>nums[index]) return i;
        }
        return index;
    }
    public static void main(String[] args) {
        int[] nums=new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i]= (int) (Math.random()*10);
        }
        nums=new int[]{9,9,6,3,2};
        System.out.println(Arrays.toString(nums));
        new LC31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
