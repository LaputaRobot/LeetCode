public class LC416 {
    public static void main(String[] args) {
        System.out.println(new LC416().canPartition1(new int[]{2,2,3,5}));
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum%2!=0)return false;
        int target=sum/2;
        int n=nums.length;
        boolean[][] dp=new boolean[n][target+1];
        dp[0][nums[0]]=true;
        for (int i = 0; i < n; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j<nums[i])dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]|dp[i-1][j-nums[i]];
            }
        }
        return dp[n-1][target];
    }
    public boolean canPartition1(int[] nums) {
        int sum=0;
        int max=0;
        for (int num : nums) {
            sum+=num;
            max=Math.max(max,num);
        }
        int n=nums.length;
        int target=sum/2;
        if (sum%2!=0||n==1||max>target)return false;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] | dp[j - num];
            }
        }
        return dp[target];
    }

}
