import java.util.Arrays;

public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0)return new int[]{};
        int[] res=new int[matrix.length*matrix[0].length];
        int m_len=matrix.length;
        int n_len=matrix[0].length;
        int i=0;
        int j=0;
        int index=0;
        while (n_len>0&&m_len>0){
            int end_j=j+n_len;
            for (; j < end_j; j++) {
                res[index++]=matrix[i][j];
            }
            m_len--;
            if (m_len==0)break;
            i++;
            j--;
            int end_i=i+m_len;
            for (; i < end_i; i++) {
                res[index++]=matrix[i][j];
            }
            j--;
            i--;
            n_len--;
            if (n_len==0)break;
            end_j=j-n_len;
            for (; j > end_j; j--) {
                res[index++]=matrix[i][j];
            }
            i--;
            j++;
            m_len--;
            if (m_len==0)break;
            end_i=i-m_len;
            for (; i > end_i; i--) {
                res[index++]=matrix[i][j];
            }
            i++;
            j++;
            n_len--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[][]{{1, 2, 3, 4,6}, {5, 6, 7, 8,0}, {9, 10, 11, 12,9}};
        System.out.println(Arrays.toString(new Offer29().spiralOrder(matrix)));
    }
}
