import java.util.Arrays;
import java.util.Comparator;

public class LC435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
            } else count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LC435().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
