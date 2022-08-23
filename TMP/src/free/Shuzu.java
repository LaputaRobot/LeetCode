package free;

import java.util.Arrays;

public class Shuzu {
    public static void main(String[] args) {
        int[][] m=new int[][]{{1, 2, 3,4}, {4, 5, 6,7}, {7, 8, 9,10}, {7, 8, 9,10}, {7, 8, 9,10}};
        System.out.println(Arrays.toString(new Shuzu().antiSpiralOrder(m)));
    }
    public int[] antiSpiralOrder (int[][] matrix) {
        // write code here
        int m=matrix.length;
        int n=matrix[0].length;
        int[] res=new int[m*n];
        int index=0;
        int i=m-1,j=-1;
        m--;
        while (m>0||n>0) {
            for (int t=1; t <=n; t++) {
                res[index++]=matrix[i][j+t];
            }
            j+=n;
            n--;
            if (m==0)break;
            for (int t=1; t <=m; t++) {
                res[index++]=matrix[i-t][j];
            }
            i-=m;
            m--;
            if (n==0)break;
            for (int t=1; t <=n; t++) {
                res[index++]=matrix[i][j-t];
            }
            j-=n;
            n--;
            if (m==0)break;
            for (int t=1; t <=m; t++) {
                res[index++]=matrix[i+t][j];
            }
            i+=m;
            m--;
        }
        return res;
    }
}
