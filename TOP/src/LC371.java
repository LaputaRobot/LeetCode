public class LC371 {
    public int getSum(int a, int b) {
        boolean z=false;
        int res=0;
        int tmp=1;
        while (a!=0||b!=0||z){
            int x=a&1;
            int y=b&1;
            a>>>=1;
            b>>>=1;
            if (x==1&&y==1){
                if (z) res=res|tmp;
                z=true;
            }
            else if (x==0&&y==0){
                if (z) res=res|tmp;
                z=false;
            }
            else if ((x^y)==1){
                if (!z){
                    res=res|tmp;
                    z=false;
                }
            }
            tmp<<=1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC371().getSum(Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}
