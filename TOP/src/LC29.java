import java.util.Stack;

public class LC29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        int flag=0;
        if (dividend>0) {
            dividend = -dividend;
            flag++;
        }
        if (divisor>0) {
            divisor = -divisor;
            flag++;
        }
        Stack<Integer> help=new Stack<>();
        int e=divisor;
        int res=0;
        while (e>=dividend) {
            if (e>=0) break;
            help.add(e);
            e+=e;
        }
        while (dividend<=divisor){
            while (help.peek()<dividend)help.pop();
            res+=1<<(help.size()-1);
            dividend-=help.peek();
        }
        if (flag==1)return -res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC29().divide(Integer.MIN_VALUE,Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE/-2);
    }
}
