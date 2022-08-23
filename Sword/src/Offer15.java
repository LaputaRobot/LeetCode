public class Offer15 {
    public int hammingWeight(int n) {
        int res=0;
        int helper=1;
        while (n!=0){
            if ((n&helper)==1)res++;
            n>>>=1;
        }
        return res;
    }
    public int hammingWeight1(int n) {
        int res=0;
        int helper=1;
        while (n!=0){
            res++;
            n&=(n-1);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Offer15().hammingWeight1(-3));
    }
}
