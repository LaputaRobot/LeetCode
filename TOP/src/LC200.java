public class LC200 {
    static int[][] directions=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public int numIslands(char[][] grid) {
        boolean[][] rec=new boolean[grid.length][grid[0].length];
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]!='0') {
                    if (!rec[i][j]){
                        res += 1;
                        spread(grid,rec,i,j);
                    }
                }
            }
        }
        return res;
    }
    public static void spread(char[][] grid,boolean[][] rec,int i,int j){
        for (int[] d: directions) {
            if (i+d[0]>-1&&i+d[0]<rec.length&&j+d[1]>-1&&j+d[1]<rec[0].length) {
                if (grid[i + d[0]][j + d[1]]=='1'&&!rec[i + d[0]][j + d[1]]) {
                    rec[i + d[0]][j + d[1]]=true;
                    spread(grid,rec,i + d[0],j + d[1]);
                }
            }
        }
    }
    public static boolean isAnother(boolean[][] rec,int i,int j){
        for (int[] d: directions) {
            if (i+d[0]>-1&&i+d[0]<rec.length&&j+d[1]>-1&&j+d[1]<rec[0].length) {
                if (rec[i + d[0]][j + d[1]]) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] grid=new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(new LC200().numIslands(grid));
    }
}
