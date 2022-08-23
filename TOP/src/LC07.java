public class LC07 {
    //做了部分优化
    public static int reverse(int x) {
        if (x==Integer.MIN_VALUE) return 0;
        boolean flag=false;
        if (x<0) {
            x = -x;
            flag=true;
        }
        int res=0;
        while (x>0){
            if (res>Integer.MAX_VALUE/10)  return 0;
            res=res*10+x%10;
            x/=10;
        }
        return flag?-res:res;
    }

    public static void main(String[] args) {
        int x=-1463847412;
        System.out.println(reverse(x));
    }
}
