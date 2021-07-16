import java.util.LinkedList;
import java.util.Stack;

public class lc739 {
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int current=T[i];
            while (!stack.empty()&&current>T[stack.peek()]){
                res[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] t={73};
        for (int i: dailyTemperatures(t)) {
            System.out.print(""+i+", ");
        }
    }
}
