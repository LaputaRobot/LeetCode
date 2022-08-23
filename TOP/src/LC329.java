public class LC329 {
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        int res=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int tmp=dfs(matrix,dp,i,j);
                if (tmp>res)res=tmp;
            }
        }
        return res;
    }
    public int dfs(int[][] matrix,int[][] dp,int i, int j){
        if (dp[i][j]!=0)return dp[i][j];
        int res=0;
        for (int[] d: directions) {
            if (i+d[0]>=0&&i+d[0]<matrix.length&&j+d[1]>=0&&j+d[1]<matrix[0].length&&matrix[i][j]>matrix[i+d[0]][j+d[1]]) {
                int tmp = dfs(matrix, dp, i + d[0], j + d[1]);
                if (tmp > res) res = tmp;
            }
        }
        dp[i][j]=res+1;
        return dp[i][j];
    }
    public static void main(String[] args) {
        int[][] matrix={{3,4,5}, {3, 2, 6},{2,2,1}};
        System.out.println(new LC329().longestIncreasingPath(matrix));
    }
}
