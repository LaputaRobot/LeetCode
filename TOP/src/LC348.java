import java.util.HashMap;

class TicTacToe {
    int[][] rows,clos,d;
    public TicTacToe(int n) {
        rows=new int[2][n];
        clos=new int[2][n];
        d=new int[2][2];
    }

    public int move(int row, int col, int player) {
        rows[player-1][row]+=1;
        if (rows[player-1][row]==4)return player;
        clos[player-1][col]+=1;
        if (clos[player-1][col]==4) return player;
        if (row==col)d[0][player-1]+=1;
        if (d[0][player-1]==4)return player;
        if (row+col==rows[0].length-1) d[1][player-1]+=1;
        if (d[1][player-1]==4)return 1;
        return 0;
    }
}
public class LC348 {
    public static void main(String[] args) {
    }

}
