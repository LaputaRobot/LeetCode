import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int i1=0,i2=matrix.length-1,i=0;
        int j1=0,j2=matrix[0].length-1,j=0;
//        if (i2==j2&&i2==1){res.add(matrix[0][0]);return res;}
        while (i1<=i2&&j1<=j2){
            for (j = j1; j <= j2; j++) {
                res.add(matrix[i][j]);
            }
            j--;
            i1++;
            if (i1>i2) break;
            for (i= i1; i <= i2; i++) {
                res.add(matrix[i][j]);
            }
            i--;
            j2--;
            if (j1>j2)break;
            for (j = j2; j>=j1 ; j--) {
                res.add(matrix[i][j]);
            }
            j++;
            i2--;
            if (i1>i2)break;
            for ( i = i2; i >=i1; i--) {
                res.add(matrix[i][j]);
            }
            i++;
            j1++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix={{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},{13, 14, 15, 16}};
        int[][] m={{1}};
        System.out.println(new LC54().spiralOrder(m));
    }
}
