import java.util.HashMap;
import java.util.Stack;

public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed={1,2,6,4,3,6,4,6,7};
        int[] popped={4,6,6,7,3,4,6,2,1};
        System.out.println(new Offer31().validateStackSequences(pushed,popped));
    }
}
