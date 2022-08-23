public class LC279 {
    public int numSquares(int n) {
        if (n==1) return 1;
        int[] dp=new int[n+1];
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            int t=Integer.MAX_VALUE;
            for (int j = 1; j*j<=i; j++) {
                t=Math.min(t,dp[i-j*j]);
            }
            dp[i]=1+t;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 1; i < 25; i++) {
            System.out.print(i+": ");
            System.out.println(new LC279().numSquares(i));
        }
    }
}
