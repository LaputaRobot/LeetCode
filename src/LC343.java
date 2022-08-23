public class LC343 {
    public static void main(String[] args) {
        System.out.println(new LC343().integerBreak(35));
    }
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        if (n==2)return 1;
        if (n==3)return 2;
        for (int i = 4; i < n + 1; i++) {
            for (int j = 2; j <= 3; j++) {
//                int j=i/2;
                dp[i]=Math.max(dp[i],Math.max(j,dp[j])*Math.max(i-j,dp[i-j]));
//                System.out.printf("%s %s %s %s\n",i,j,i-j,dp[i]);
            }
        }
        return dp[n];
    }
}
