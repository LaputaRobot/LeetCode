import java.util.Arrays;

public class LC494 {
    public static void main(String[] args) {
        System.out.println(new LC494().findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum || target < -sum) return 0;
        int[] dp1 = new int[2 * sum + 1];
        dp1[nums[0] + sum] += 1;
        dp1[-nums[0] + sum] += 1;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int[] dp2 = new int[2 * sum + 1];
            for (int j = -sum; j < sum + 1; j++) {
                int jj = j + sum;
                if (jj + num <= 2 * sum)
                    dp2[jj] += dp1[jj + num];
                if (jj - num >= 0)
                    dp2[jj] += dp1[jj - num];
            }
            dp1=Arrays.copyOf(dp2,dp2.length);
        }
        return dp1[target + sum];
    }
}
