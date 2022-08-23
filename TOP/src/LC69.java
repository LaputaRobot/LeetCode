public class LC69 {
    public int mySqrt(int x) {
        int left=0,right=46340;
        int mid=(left+right)/2;
        while (left<=right){
            mid=(left+right)/2;
            int tmp1=mid*mid;
            int tmp2=(mid+1)*(mid+1);
            if (tmp1==x||(tmp1<x&&tmp2>x))return mid;
            else if (tmp1>x) right=mid-1;
            else left=mid+1;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(new LC69().mySqrt(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);
    }
}
