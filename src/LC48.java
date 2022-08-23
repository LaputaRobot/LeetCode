import java.util.Arrays;

public class LC48 {
    public void rotate(int[][] matrix) {
        int temp=0;
        int i = 0;
        int j = matrix.length-1;
        while (j >i){
            for (int k = 0; k < j-i; k++) {
                temp=matrix[j-k][i];
                matrix[j-k][i]=matrix[j][j-k];
                matrix[j][j-k]=matrix[i+k][j];
                matrix[i+k][j]=matrix[i][i+k];
                matrix[i][i+k]=temp;
            }
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix={{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new LC48().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
