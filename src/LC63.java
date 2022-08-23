import java.util.Arrays;

public class LC63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        if (obstacleGrid[m-1][n-1]==1)return 0;
        dp[m-1][n-1]=1;
        for (int i = m-2; i >=0; i--) {
            if (obstacleGrid[i][n-1]==1)dp[i][n-1]=0;
            else dp[i][n-1]=dp[i+1][n-1];
        }
        for (int i = n-2; i >=0; i--) {
            if (obstacleGrid[m-1][i]==1)dp[m-1][i]=0;
            else dp[m-1][i]=dp[m-1][i+1];
        }
        m-=2;
        n-=2;
        while (m>=0&&n>=0){
            for (int i = m; i >=0; i--) {
                if (obstacleGrid[i][n]==1)dp[i][n]=0;
                else dp[i][n]=dp[i+1][n]+dp[i][n+1];
            }
            n--;
            for (int j = n; j >=0; j--) {
                if (obstacleGrid[m][j]==1)dp[m][j]=0;
                else dp[m][j]=dp[m+1][j]+dp[m][j+1];
            }
            m--;
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new LC63().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
