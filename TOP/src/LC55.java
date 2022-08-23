public class LC55 {
    public boolean canJump(int[] nums) {
        boolean[] helper=new boolean[nums.length];
        helper[nums.length-1]=true;
        for (int i = nums.length-2; i >=0 ; i--) {
            for (int j = i+1; j <= i+nums[i]; j++) {
                if (helper[j]) {
                    helper[i] = true;
                    break;
                }
            }
        }
        return helper[0];
    }
    public boolean canJump1(int[] nums) {
        int right=nums[0];
        for (int i = 0; i <= right ; i++) {
            int t=nums[i]+i;
            if (t>right) right=t;
            if (right>=nums.length-1) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(new LC55().canJump1(nums));
    }
}
