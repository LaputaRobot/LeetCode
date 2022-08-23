public class LC73 {
    public void setZeroes(int[][] matrix) {
        boolean r0=false,c0=false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==0) {
                c0 = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j]==0){
                r0=true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0]==0){
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j]==0){
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j]=0;
                }
            }
        }
        if (r0){
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j]=0;
            }
        }
        if (c0){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m={{-4, -2147483648, 6, -7, 0}, {-8, 6, -8, -6, 0}, {2147483647, 2, -9, -6, -10}};
        new LC73().setZeroes(m);
    }
}
