public class LC746 {
    public static void main(String[] args) {
        System.out.println(new LC746().minCostClimbingStairs(new int[]{10,15,20}));
    }
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        int[] dp=new int[len+1];
        for (int i = 0; i < len+1; i++) {
            if (i<=1)dp[i]=cost[i];
            else if (i==len) dp[i]=Math.min(dp[i-1],dp[i-2]);
            else dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return dp[len];
    }
}
