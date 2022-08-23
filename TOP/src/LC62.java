public class LC62 {
    public int uniquePaths(int m, int n) {
        int[][] helper=new int[m][n];
        for (int i = 0; i < m; i++) {
            helper[i][n-1]=1;
        }
        for (int j = 0; j < n; j++) {
            helper[m-1][j]=1;
        }
        int x=m-2;
        int y=n-2;
        while (x>=0&&y>=0) {
            for (int i = x; i >= 0; i--) {
                helper[i][y]=helper[i+1][y]+helper[i][y+1];
            }
            y--;
            for (int j = y; j >=0 ; j--) {
                helper[x][j]=helper[x+1][j]+helper[x][j+1];
            }
            x--;
        }
        return helper[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new LC62().uniquePaths(3,7));
    }
}
