import java.util.*;

public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i < k-1; i++) {
            while (deque.size() > 0 && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        for (int i = k-1; i < n; i++) {
            while (deque.size()>0&&nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            res[i-k+1]=nums[deque.peekFirst()];
            while (deque.size()>0&&deque.peekFirst()<=i-k+1)deque.pollFirst();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={3,3,1,-3,5,3,6,7};
        System.out.println(Arrays.toString(new LC239().maxSlidingWindow1(nums, 1)));
    }
}
