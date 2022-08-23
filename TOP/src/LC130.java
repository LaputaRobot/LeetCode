import java.util.HashSet;
import java.util.Set;

public class LC130 {
    int[][] directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0]=='O') helper(board,i,0);
            if (board[i][board[0].length-1]=='O') helper(board,i,board[0].length-1);
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j]=='O') helper(board,0,j);
            if (board[board.length-1][j]=='O') helper(board,board.length-1,j);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='O') board[i][j]='X';
                if (board[i][j]=='A') board[i][j]='O';
            }
        }
    }
    public void helper(char[][] board,int i,int j){
        if (i<0||i>board.length-1)return;
        if (j<0||j>board[0].length-1)return;
        if (board[i][j]=='O') {
            board[i][j]='A';
            for (int[] direction:directions ) {
               helper(board,i+direction[0],j+direction[1]);
            }
        }
    }
    public static void main(String[] args) {

    }
}
