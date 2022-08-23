import java.util.Arrays;
import java.util.Comparator;

public class LC452 {
    public static void main(String[] args) {
        System.out.println(new LC452().findMinArrowShots1(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0]==o2[0]){
                if (o1[1]==o2[1])return 0;
                return o1[1]>o2[1]?1:-1;
            }
            else {
                return o1[0]>o2[0]?1:-1;
            }
        });
        int res=1;
        int left=points[0][0];
        int right=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]>right){
                res++;
                left=points[i][0];
                right=points[i][1];
            }
            else {
                left=Math.max(left,points[i][0]);
                right=Math.min(right,points[i][1]);
            }
        }
        return res;
    }
    public int findMinArrowShots1(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int res=1;
        int left=points[0][0];
        int right=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]>right){
                res++;
                left=points[i][0];
                right=points[i][1];
            }
            else {
                left=Math.max(left,points[i][0]);
                right=Math.min(right,points[i][1]);
            }
        }
        return res;
    }
}
