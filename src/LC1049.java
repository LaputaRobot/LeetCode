import java.util.Arrays;
import java.util.Random;

public class LC1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int half = sum / 2;
        int n = stones.length;
        boolean[][] dp = new boolean[n + 1][half + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= half; j++) {
                if (stones[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                }
            }
        }
        for (int j = half; j >= 0; j--) {
            if (dp[n][j]) return sum - 2 * j;
        }
        return sum - 2 * half;
    }

    public int lastStoneWeightIII(int[] stones) {
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int half = sum / 2;
        int n = stones.length;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            int s = stones[i - 1];
            for (int j = half; j >= s; j--) {
                dp[j] = dp[j] || dp[j - s];
            }
        }
        for (int j = half; j >= 0; j--) {
            if (dp[j]) return sum - 2 * j;
        }
        return sum - 2 * half;
    }

    public static void main(String[] args) {
        Random random = new Random(1);
        int len = (int) (random.nextFloat() * 10 + 1);
        int[] stones = new int[len];
        for (int i = 0; i < len; i++) {
            stones[i] = random.nextInt(50);
        }
        stones = new int[]{31, 26, 33, 21, 40};
        System.out.println(Arrays.toString(stones));
        System.out.println(new LC1049().lastStoneWeightIII(stones));
    }
}
