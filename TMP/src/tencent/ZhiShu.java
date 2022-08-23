package tencent;

public class ZhiShu {
    public int getNumber (int[] a) {
        // write code here
        int[] b=new int[a.length];
        int len=a.length;
        int index=len;
        int lastIndex=len;
        while (index>1){
            index=0;
            for (int i = 1; i <= lastIndex; i++) {
                if (isP(i)){
                    b[index++]=a[i-1];
                }
            }
            int[] tmp=a;
            a=b;
            b=tmp;
            lastIndex=index;
        }
        return a[0];
    }
    public static boolean isP(int x){
        int i=2;
        for (; i <= x/2; i++) {
            if (x%i==0)break;
        }
        return i>x/2&&x!=1;
    }

    public static void main(String[] args) {
        System.out.println(new ZhiShu().getNumber(new int[]{3,1,1,4,5,6}));
    }
}
