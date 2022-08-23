public class LC172 {
    public int trailingZeroes(int n) {
        int res=0;
        int x=5;
        while (n>=x){
            res+=(n/x);
            x*=5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC172().trailingZeroes(125));
    }
}
