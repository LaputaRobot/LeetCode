public class LC204 {
    public int countPrimes(int n) {
        boolean[] rec=new boolean[n+1];
        int res=0;
        for (int i = 2; i < n; i++) {
            if (!rec[i]) {
                res += 1;
                int tmp=i+i;
                while (tmp<=n){
                    rec[tmp]=true;
                    tmp+=i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
