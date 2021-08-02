public class LC994 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        int times=0;
        int rand=2;
        int oneNum=0;
        for (rand = 2; ; rand++) {
            times=0;
            oneNum=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j]==rand) {
                        int xx, yy;
                        for (int k = 0; k < 4; k++) {
                            xx = i + dx[k];
                            yy = j + dy[k];
                            if (xx >= 0 && xx <= grid.length - 1 && yy >= 0 && yy <= grid[0].length - 1) {
                                if (grid[xx][yy] == 1) {
                                    grid[xx][yy]=rand+1;
                                    times++;
                                }
                            }
                        }
                    }
                    if (grid[i][j]==1) oneNum++;
                }
            }
            if (times==0) {
                if (oneNum>0) return -1;
                else break;
            }
        }
        return rand-2;
    }

    public static void main(String[] args) {
        LC994 lc994=new LC994();
//        int[][] grid={{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] grid={{0,2}};
        System.out.println(lc994.orangesRotting(grid));
    }
}
