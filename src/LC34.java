import java.util.Arrays;

public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0) return new int[]{-1,-1};
        int start=0,end=nums.length-1;
        int mid=start+(end-start)/2;
        while (nums[start]!=nums[end]){
            if (nums[mid]>target){
                while (nums[mid]==nums[--mid]){
                }
                end=mid;
            }
            else if (nums[mid]<target){
                while (nums[mid]==nums[++mid]){
                }
                start=mid;
            }
            else break;
            if (target>nums[end]||target<nums[start]) break;
        }
        if (nums[mid]!=target) {
            return new int[]{-1,-1};
        }
        else {
            start=mid;
            end=mid;
            while (start>=0&&nums[start]==target) start--;
            while (end<=nums.length- 1&&nums[end]==target) end++;
            return new int[]{start+1,end-1};
        }
    }
    public static void main(String[] args) {
        LC34 lc34=new LC34();
        int[] nums=new int[]{1,1,1,2,2,3,4,5,6,6,6,6,6};
        System.out.println(Arrays.toString(lc34.searchRange(nums,1)));
    }
}
