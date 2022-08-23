public class Offer10 {
    public int fib(int n) {
        if (n<=1)return n;
        int[] res=new int[n+1];
        res[1]=1;
        for (int i = 2; i <= n; i++) {
            res[i]=(res[i-1]+res[i-2])%1000000007;
        }
        return res[n];
    }
    public int fib1(int n){
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
    public int numWays(int n){
        if (n<=1)return n;
        if (n==2)return 2;
        int a=1,b=2,res=0;
        for (int i=3;i<n;i++){
            res=(a+b)%1000000007;
            a=b;
            b=res;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Offer10().numWays(5));

    }
}
