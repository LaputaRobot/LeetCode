import java.util.*;

public class LC121 {
    public int maxProfit(int[] prices) {
        Stack<Integer> stack=new Stack<>();
        int max=-1;
        for (int i = prices.length-1; i > 0 ; i--) {
            if (prices[i]>=max){
                max=prices[i];
                stack.push(max);
            }
        }
        int res=0;
        for (int i = 0; i < prices.length-1; i++) {
            if (i>0&&prices[i]==stack.peek()) stack.pop();
            if (stack.peek()-prices[i]>res){
                res=stack.peek()-prices[i];
            }
        }
        return res;
    }
    public int maxProfit1(int[] prices) {
        int res=0;
        boolean has=false;
        int l=0;
        for (int i = 0; i < prices.length; i++) {
            if (!has){
                if (i+1>prices.length-1) break;
                else if(prices[i]<prices[i+1]){
                    l=prices[i];
                    has=true;
                }
            }
            else {
                if (i+1>prices.length-1||prices[i]>prices[i+1]){
                    res+=(prices[i]-l);
                    has=false;
                }
            }
        }
        return res;
    }
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }

    public static void main(String[] args) {
        Random r=new Random();
//        r.setSeed(5);
        for (int t = 0; t < 100; t++) {
            int m= r.nextInt(30000);
            int[] nums=new int[m];
            for (int i = 0; i < m; i++) {
                nums[i]=r.nextInt(10000);
            }
//            nums=new int[]{1, 13, 2, 18, 18, 16, 17, 4, 15, 19, 3, 0, 7};
//            System.out.println(Arrays.toString(nums));
            int res1=new LC121().maxProfit1(nums);
            int res2=new LC121().maxProfit2(nums);
//            System.out.println();
            if (res1!=res2) {
                System.out.println(Arrays.toString(nums));
                System.out.println(res1);
                System.out.println(res2);
            }
        }
    }
}
