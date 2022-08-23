public class LC714 {
    public static void main(String[] args) {
        System.out.println(new LC714().maxProfit(new int[]{4,5,2,4,3,3,1,2,5,4},1));
    }
    public int maxProfit(int[] prices, int fee) {
        int len=prices.length;
        int res=0;
        int left=prices[0],right=left;
        for (int i = 1; i < len; i++) {
            if (prices[i]>right)right=prices[i];
            else {
                if (right-prices[i]>fee){
                    if (right-left>fee)res+=(right-left-fee);
                    left = prices[i];
                    right = left;
                }
                else {
                    if (prices[i]<left){
                        left = prices[i];
                        right = left;
                    }
                }
            }
            if (i==len-1&&right-left>fee)res+=(right-left-fee);
        }
        return res;
    }
}
