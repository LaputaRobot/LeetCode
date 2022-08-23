public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
       int x=0,y=matrix[0].length-1;
       while (y>=0){
           if (matrix[x][y]==target)return true;
           if (matrix[x][y]<target) x++;
           if (x>matrix.length-1)break;
           if (matrix[x][y]>target) y--;
       }
       return false;
    }

    public static void main(String[] args) {
        int[][] nums={{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(new LC240().searchMatrix(nums,20));

    }
}
