public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start1=0,start2=0,end1=matrix.length-1,end2=matrix[0].length-1;
        int n=matrix[0].length;
        while (end1*n+end2-(start1*n+start2)>=0){
            int len=(end1*n+end2-(start1*n+start2))/2;
            int mid1=start1+(len+start2)/n;
            int mid2 = (start2 + len) % n;
            if (target==matrix[mid1][mid2]) return true;
            if (target>matrix[mid1][mid2]) {
                if (mid2+1>n-1){
                    start1=mid1+1;
                    start2=0;
                }else {
                    start1=mid1;
                    start2=mid2+1;
                }
            }
            if (target<matrix[mid1][mid2]) {
                if (mid2-1<0){
                    end1=mid1-1;
                    end2=n-1;
                }else {
                    end1=mid1;
                    end2=mid2-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC74 lc74=new LC74();
//        int[][] matrix=new int[][]{{1, 3, 5, 7},{10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix=new int[][]{{1}};
        for (int i = 1; i < 61; i++) {
            if (lc74.searchMatrix(matrix,i)){
                System.out.println(i);
            }
        }
//        System.out.println(lc74.searchMatrix(matrix,60));
    }
}
