public class LC79 {
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        boolean res;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if (helper(board,word,i,j,0)) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board,String word,int i,int j,int index){
        if (index==word.length()) return true;
        if (i<0||i>=board.length) return false;
        if (j<0||j>=board[0].length) return false;
        char ch=board[i][j];
        if (ch=='*') return false;
        if (ch==word.charAt(index)){
            board[i][j]='*';
            for (int[] d : directions) {
                if (helper(board,word,i+d[0],j+d[1],index+1)) return true;
            }
            board[i][j]=ch;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board={{'A', 'B', 'C', 'E'}, {'A', 'B', 'C', 'D'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new LC79().exist(board,"ABCD"));
    }
}
