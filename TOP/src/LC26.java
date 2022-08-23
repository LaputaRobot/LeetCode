public class LC26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length<2) return nums.length;
        int l=0,r=1;
        while (r<nums.length){
            if (nums[l]<nums[r]) nums[++l]=nums[r];
            else r++;
        }
        return l+1;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        int res=new LC26().removeDuplicates(nums);
        System.out.println(res);
    }
}
