public class LC136 {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i]=(nums[i]^nums[i-1]);
        }
        return nums[nums.length-1];
    }
    public static void main(String[] args) {
        int[]   nums= {1,2,2,1,6,3,4,4,3};
        LC136 lc136=new LC136();
        System.out.println(lc136.singleNumber(nums));
//        System.out.println(~0b11111111111111111111111111111111);
    }
}
