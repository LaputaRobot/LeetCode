public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0)return false;
        int x=0,y=matrix[0].length-1;
        while (x<=matrix.length-1&&y>=0){
            if (matrix[x][y]>target)y--;
            else if (matrix[x][y]<target)x++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        matrix=new int[][]{{1}};
        int target=1;
        System.out.println(new Offer04().findNumberIn2DArray(matrix,target));
    }
}
