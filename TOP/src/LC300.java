public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int right=0;
        dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int l=0;
            int r=right;
            int mid=0;
            while (l<=r){
                mid=(l+r)>>1;
                if (dp[mid]>nums[i]) {
                    if (mid==0||dp[mid-1]<nums[i]){
                        dp[mid]=nums[i];
                        break;
                    }
                    else r = mid - 1;
                }
                else if (dp[mid]<nums[i]) l=mid+1;
                else break;
            }
            if (nums[i]>dp[mid]) dp[++right]=nums[i];
        }
        return right+1;
    }

    public static void main(String[] args) {
        System.out.println(new LC300().lengthOfLIS(new int[]{-2,-1,0}));
    }
}
