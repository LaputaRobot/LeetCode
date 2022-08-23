import java.util.Arrays;

public class LC62 {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        Arrays.fill(dp[m-1],1);
        for (int i = 0; i < m; i++) {
            dp[i][n-1]=1;
        }
        m-=2;
        n-=2;
        while (m>=0&&n>=0){
            for (int i = m; i >=0; i--) {
                dp[i][n]=dp[i+1][n]+dp[i][n+1];
            }
            n--;
            for (int j = n; j >=0; j--) {
                dp[m][j]=dp[m+1][j]+dp[m][j+1];
            }
            m--;
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new LC62().uniquePaths(3,3));
    }
}
