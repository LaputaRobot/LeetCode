public class LC45 {
    public int jump(int[] nums) {
        int left = 0, right = 0;
        int step = 0;
        int nextR = right;
        while (true) {
            if (right >= nums.length - 1) break;
            for (int i = left; i <= right; i++) {
                if (nums[i] + i > nextR) {
                    nextR = nums[i] + i;
                }
            }
            left = right + 1;
            right = nextR;
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new LC45().jump(new int[]{2}));
    }
}
