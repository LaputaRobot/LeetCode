import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Offer66 {
    public int[] constructArr(int[] a) {
        Stack<Integer> s=new Stack<>();
        int[] b=new int[a.length];
        int m=1;
        s.add(m);
        for (int i = 0; i < a.length-1; i++) {
            m*=a[i];
            s.add(m);
        }
        int n=1;
        for (int i = a.length-1; i >= 0; i--) {
            m=s.pop();
            b[i]=m*n;
            n*=a[i];
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer66().constructArr(new int[]{2,3,1,4,5})));
    }
}
