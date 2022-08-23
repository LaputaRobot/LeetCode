public class Offer14 {
    public int cuttingRope(int n) {
        if (n<4)return n-1;
        int res=1;
        while (n>4){
            res*=(3);
            n-=3;
        }
        if (n<=3) return res*n;
        return res*2*2;
    }

    public static void main(String[] args) {
        System.out.println(new Offer14().cuttingRope(58));
    }
}
