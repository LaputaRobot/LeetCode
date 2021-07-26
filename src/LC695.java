public class LC695 {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    int num=0;
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    num=0;
                    getMax(grid,i,j);
                    if (num>max) max=num;
                }
            }
        }
        return max;
    }
    public void getMax(int[][] grid,int x,int y){
        grid[x][y]=2;
        num++;
        int xx=x,yy=y;
        for (int i = 0; i < 4; i++) {
            xx=x+dx[i];
            yy=y+dy[i];
            if (xx>=0&&xx<=grid.length-1&&yy>=0&&yy<=grid[0].length-1&&grid[xx][yy]==1){
                getMax(grid,xx,yy);
            }
        }
    }
    public  static void main(String[] args) {
        int[][] grid=new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        LC695 ins=new LC695();
        System.out.println(ins.maxAreaOfIsland(grid));
    }
}
