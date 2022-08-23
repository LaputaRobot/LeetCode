import java.util.Arrays;

public class Offer63 {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int res=0;
        for (int price : prices) {
            if (price - min > res) res = price - min;
            if (price < min) {
                min = price;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices=new int[]{7,2,5,3,6,4,6,4,7,2,9,1,5,3,6,8,6,4};
        System.out.println(new Offer63().maxProfit(prices));
    }
}
