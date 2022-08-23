import java.util.Arrays;

public class LC1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                sum -= nums[i];
                k--;
            } else break;
        }
        if (k % 2 != 0) {
            if (i==nums.length||i>0&&-nums[i - 1] < nums[i]) {
                sum += 2*nums[i - 1];
            } else
                sum -= nums[i++];
        }
        for (; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LC1005().largestSumAfterKNegations(new int[]{-4,-2,-3}, 4));
    }
}
