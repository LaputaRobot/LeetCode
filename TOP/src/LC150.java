import java.util.Stack;

public class LC150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(x + y);
                    break;
                }
                case "-": {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y - x);
                    break;
                }
                case "*": {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(x * y);
                    break;
                }
                case "/": {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y / x);
                    break;
                }
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens=new String[]{"2"};
        System.out.println(new LC150().evalRPN(tokens));
    }
}
