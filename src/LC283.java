import java.util.Arrays;
// 思路对了，但是代码运行的时间和内存消耗大，可优化
public class LC283 {
    public static void moveZeroes(int[] nums) {
        int start=0,end=0;
        while (end<nums.length-1) {
            while (start<=nums.length-2&&nums[start] != 0) start++;
            end = start;
            while (end<=nums.length-2&&nums[end] == 0) end++;
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
