public class LC198 {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);
        int[] record=new int[nums.length];
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if (i==0)record[0]=nums[0];
            else if (i==1) record[1]=nums[1];
            else if (i==2) record[i]=nums[0]+nums[i];
            else record[i]=Math.max(record[i-2],record[i-3])+nums[i];
            if (record[i]>max) max=record[i];
        }
        return max;
    }

    public static void main(String[] args) {
        LC198 lc198=new LC198();
        int[] nums={1,3};
        System.out.println(lc198.rob(nums));
    }
}
