public class Offer65 {
    public int add(int a, int b) {
        int res=0;
        int last=0;
        int th=0;
        int times=0;
        while (a!=0||b!=0||last!=0){
            if (((a&1)|(b&1))==0){
                th=last;last=0;
            }
            else {
                if (((a&1)&(b&1))==1) {
                    th=last;last=1;
                }
                else {
                    if (last==1){
                        th=0;last=1;
                    }
                    else {
                        th=1;last=0;
                    }
                }
            }
            th<<=times;
            res|=th;
            times++;
            a>>>=1;
            b>>>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Offer65().add(-2,-8));
    }
}
