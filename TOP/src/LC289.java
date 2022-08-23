import java.util.Arrays;

public class LC289 {
    public void gameOfLife(int[][] board) {
        int[][] directions=new int[][]{{-1,0},{1,0},{0,1},{0,-1},{-1,1},{1,1},{-1,-1},{1,-1}};
        int[][] dp=new int[board.length][board[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (board[i][j]==1) {
                    for (int[] d : directions) {
                        if (i+d[0]>=0&&i+d[0]<board.length&&j+d[1]>=0&&j+d[1]<board[0].length){
                            dp[i+d[0]][j+d[1]]+=1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==0){
                    if (dp[i][j]==3) board[i][j]=1;
                }
                else {
                    if (dp[i][j]<2||dp[i][j]>3) board[i][j]=0;
                }
            }
        }
    }
    public void gameOfLife1(int[][] board) {
        int[] d={-1,0,1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num=0;
                for (int k = 0; k < 3; k++) {
                    if (i+d[k]>=0&&i+d[k]<board.length) {
                        for (int l = 0; l < 3; l++) {
                            if (d[k]==0&&d[l]==0)continue;
                            if (j + d[l]>=0&&j+d[l]<board[0].length){
                                if (board[i+d[k]][j+d[l]]>=1) num++;
                            }
                        }
                    }
                }
                if (board[i][j]==0){
                    if (num==3)board[i][j]=-1;
                }
                else {
                    if (num>3||num<2)board[i][j]=2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==-1)board[i][j]=1;
                else if (board[i][j]==2) board[i][j]=0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] board={{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new LC289().gameOfLife1(board);
        System.out.println(Arrays.deepToString(board));
    }
}
