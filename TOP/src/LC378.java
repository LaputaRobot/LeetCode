import java.util.Comparator;
import java.util.PriorityQueue;

public class LC378 {
    public int kthSmallest(int[][] matrix, int k) {
        int left=matrix[0][0];
        int n=matrix.length;
        int right=matrix[n-1][n-1];
        while (left<right){
            int mid=left + ((right - left) >> 1);
            int times=helper(matrix,mid);
            if (times>=k)right=mid;
            else left=mid+1;
        }
        return left;
    }
    public int helper(int[][] matrix,int target){
        int res=0;
        int i=matrix.length-1;
        int j=0;
        while (i>=0&&j<matrix.length){
            if (matrix[i][j]<=target){
                j++;
                res+=(i+1);
            }
            else i--;
        }
        return res;
    }
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }
    public static void main(String[] args) {
        int[][] matrix={{-5,-4},{-5,-4}};
        System.out.println(new LC378().kthSmallest(matrix,2));
    }
}
