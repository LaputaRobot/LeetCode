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
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
