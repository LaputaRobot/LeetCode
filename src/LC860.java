public class LC860 {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                ten++;
                five--;
            } else if (bill == 20) {
                if (ten>0) {
                    ten--;
                    five--;
                }
                else five-=3;
            }
            if (five < 0 || ten < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LC860().lemonadeChange(new int[]{5,5,5,20}));
    }
}
