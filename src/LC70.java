public class LC70 {
    public int climbStairs(int n) {
        if (n<=2) return n;
        int[] record=new int[n+1];
        record[1]=1;
        record[2]=2;
        for (int i = 3; i < n+1; i++) {
            record[i]=record[i-1]+record[i-2];
        }
        return record[n];
    }

    public static void main(String[] args) {
        LC70 lc70=new LC70();
        System.out.println(lc70.climbStairs(3));
    }
}
