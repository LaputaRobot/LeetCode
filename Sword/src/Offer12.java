import java.util.*;

public class Offer12 {
    public boolean exist(char[][] board, String word) {
        int[][] directions =new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        if (word.length()==0) return false;
        ArrayList<int[]> start=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==word.charAt(0))
                    start.add(new int[]{i,j});
            }
        }
        LinkedList<String> record=new LinkedList<>();
        for (int[] s: start) {
            record.add(Arrays.toString(s));
            for (int i = 0; i < directions.length; i++) {
                if (helper(board,word,0,s[0]+directions[i][0],s[1]+directions[i][1],record)) return true;
            }
            record.remove(Arrays.toString(s));
        }
        return false;
    }
    public boolean helper(char[][] board,String word,int index,int i,int j,LinkedList<String> record){
        index++;
        if (index>=word.length()) return true;
        if (i<0||j<0||i>=board.length||j>=board[0].length) return false;
        if (record.contains(Arrays.toString(new int[]{i,j}))) return false;
        if (board[i][j]!=word.charAt(index)) return false;
        record.add(Arrays.toString(new int[]{i,j}));
        if( helper(board,word,index,i,j-1,record)||helper(board,word,index,i,j+1,record)||helper(board,word,index,i-1,j,record)||helper(board,word,index,i+1,j,record)) return true;
        else {
            record.remove(Arrays.toString(new int[]{i,j}));
            return false;
        }
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{{'C', 'A', 'A'},{'A', 'A', 'A'},{'B','C','D'}};
        String word="AAB";
        System.out.println(new Offer12().exist(board,word));
    }
}
