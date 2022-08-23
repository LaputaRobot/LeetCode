public class LC153 {
    public int findMin(int[] nums) {
        int start=0,end=nums.length-1;
        int mid=0;
        while (start<end){
            mid=(start+end)/2;
            if (nums[start]<nums[end]) return nums[start];
            if (nums[start]>nums[end]){
                if (nums[mid]>nums[end]) start=mid+1;
                if (nums[mid]<nums[end]) end=mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        LC153 lc153=new LC153();
        int[]  nums=new int[]{3,1,2};
        System.out.println(lc153.findMin(nums));
    }
}
