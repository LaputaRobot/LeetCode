import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC253 {
    public int minMeetingRooms(int[][] intervals) {
        int[] up=new int[intervals.length];
        int[] down=new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            up[i]=intervals[i][0];
            down[i]=intervals[i][1];
        }
        Arrays.sort(up);
        Arrays.sort(down);
        int res=0;
        int count=0;
        int i=0;
        for (int j = 0; j < down.length; j++) {
            int end=down[j];
            while (i<up.length&&up[i]<=end){
                count++;
                if (up[i]==end){
                    j++;
                    end=down[j];
                    count--;
                }
                i++;
            }
            if (count>res) res = count;
            count--;
        }
        return res;
    }
    public int minMeetingRooms1(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(final int[] a, final int[] b) {
                        return a[0] - b[0];
                    }
                });

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
    public static void main(String[] args) {
        System.out.println(new LC253().minMeetingRooms1(new int[][]{{2, 10}, {4, 9}, {10, 20}, {10, 30}, {10, 30}}));
    }
}
