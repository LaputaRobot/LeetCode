public class Offer47 {
    public int maxValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] help=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j&&i==0) help[i][j]=grid[i][j];
                else if (i==0) help[i][j]=help[i][j-1]+grid[i][j];
                else if (j==0) help[i][j]=help[i-1][j]+grid[i][j];
                else help[i][j]=Math.max(help[i][j-1],help[i-1][j])+grid[i][j];
            }
        }
        return help[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] grid=new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        grid=new int[][]{{1}};
        System.out.println(new Offer47().maxValue(grid));
    }
}
