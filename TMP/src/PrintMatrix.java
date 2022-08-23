import java.util.Arrays;

public class PrintMatrix {
    public static void main(String[] args) {
        printM(2,6);
    }
    public static void printM(int m,int n){
        int i=0,j=0;
        int[][] matrix=new int[m][n];
        int num=1;
        boolean up=false;
        while (i<m&&j<n){
            if (!up){
                if (j==0&&i<m-1) {
                    matrix[i][j] = num++;
                    matrix[++i][j]=num++;
                    --i;++j;
                    up=true;
                }
                else if (i==m-1&&j<n-1){
                    matrix[i][j] = num++;
                    matrix[i][++j]=num++;
                    --i;++j;
                    up=true;
                }
                else {
                    matrix[i][j] = num++;
                    ++i;--j;
                }
            }else {
                if (i==0&&j<n-1) {
                    matrix[i][j] = num++;
                    matrix[i][++j]=num++;
                    ++i;--j;
                    up=false;
                }
                else if (j==n-1&&i<m-1){
                    matrix[i][j] = num++;
                    matrix[++i][j] = num++;
                    ++i;--j;
                    up=false;
                }
                else {
                    matrix[i][j] = num++;
                    --i;++j;
                }
            }
        }
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                System.out.printf("%3s",matrix[k][l]);
            }
            System.out.println();
        }
    }
}
