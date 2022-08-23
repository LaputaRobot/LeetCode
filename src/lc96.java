public class lc96 {
    public static int numTrees(int n) {
        if(n<=2) return n;
        int[] res=new int[n+1];
        res[0]=1;
        res[1]=1;
        res[2]=2;
        //res[3]=5;
        for (int i = 3; i < n+1; i++) {
            if(i%2==0){
                int temp=0;
                for (int j = 0; j < i/2; j++) {
                    temp=temp+res[j]*res[i-1-j];
                }
                res[i]=2*temp;
            }
            else {
                int temp=0;
                for (int j = 0; j < i/2; j++) {
                    temp=temp+res[j]*res[i-1-j];
                }
                res[i]=2*temp+res[i/2]*res[i/2];
            }
        }
        return res[n];
    }
    public static int numTrees1(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i/2; j++) {
                dp[i]+=dp[j]*dp[i-1-j];
            }
            dp[i]*=2;
            if (i%2!=0)dp[i]+=(dp[i/2]*dp[i-1-i/2]);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(numTrees1(4));
    }
}
