public class Offer53 {
    public int missingNumber(int[] nums) {
        int left=0,right=nums.length-1;
        int mid=0;
        while (left<=right){
            mid=left+(right-left)/2;
            if (nums[mid]==mid) left=mid+1;
            else{
                if (mid==0) return mid;
                if (nums[mid-1]==mid-1) return mid;
                else right=mid-1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        if (nums.length==0) return 0;
        int left=0,right=nums.length-1;
        int mid=0;
        while (left<=right){
            mid=left+(right-left)/2;
            if (nums[mid]==target)break;
            else if (nums[mid]>target)right=mid-1;
            else left=mid+1;
        }
        if (nums[mid]==target){
            left=mid-1;
            right=mid+1;
            int res=1;
            while (left>-1&&nums[left]==target) {
                res++;
                left--;
            }
            while (right<nums.length&&nums[right]==target) {
                res++;
                right++;
            }
            return res;
        }
        else return 0;
    }

    public int search1(int[] nums, int target) {
        return helper(nums,target)-helper(nums,target-1);
    }
    public int helper(int[] nums,int target){
        if (nums.length==0) return 0;
        int left=0,right=nums.length-1;
        int mid=0;
        while (left<=right) {
            mid=right+(left-right)/2;
            if (nums[mid]<=target) left=mid+1;
            else right=mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Offer53().missingNumber(new int[]{1,2,3}));
    }
}
