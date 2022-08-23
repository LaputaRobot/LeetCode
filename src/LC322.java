import java.util.Arrays;

public class LC322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 1; i <=amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return  dp[amount]>amount?-1:dp[amount];
    }

    public static void main(String[] args) {
        LC322 lc322 = new LC322();
        int[] coins = {1, 2, 5};
//        int[] coins = {12};
        System.out.println(lc322.coinChange(coins,0));
    }
}
