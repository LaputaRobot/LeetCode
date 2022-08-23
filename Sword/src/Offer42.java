public class Offer42 {
    public int maxSubArray(int[] nums) {
        int left=0;
        int res=Integer.MIN_VALUE;
        int tmpRes=0;
        for (int i = 0; i < nums.length; i++) {
            if (left==i) {
                tmpRes=nums[i];
            }
            else {
                tmpRes=tmpRes+nums[i];
            }
            if (tmpRes>res) res=tmpRes;
            if (tmpRes<0) left=i+1;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{-2};
        System.out.println(new Offer42().maxSubArray(nums));
    }
}
