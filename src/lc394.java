import java.util.Stack;

public class lc394 {
    public static String decodeString(String s) {
        String res = "";
        Stack<String> stack = new Stack<>();
        //boolean poping = false;
        for (Character ch : s.toCharArray()) {
            stack.push("" + ch);
            if (stack.peek().equals("]")) {
                //poping = true;
                stack.pop();
                String subString = "";
                Stack<String> inStack = new Stack<>();
                while (!stack.peek().equals("[")) {
                    inStack.push(stack.pop());
                }
                stack.pop();
                int times = 0;
                int base = 1;
                while (!stack.empty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
                    times = times + (stack.pop().charAt(0) - '0') * base;
                    base = base * 10;
                }
                //if(times==0)continue;
                //int tims = stack.pop().charAt(0) - '0';
                //Stack<String> temp = inStack;
                String susub = "";
                while (!inStack.empty()) {
                    susub = susub + inStack.pop();
                }
                if (times == 0) times = 1;
                for (int i = 0; i < times; i++) {
                    subString = subString + susub;
                }
                stack.push(subString);
            }
        }
        Stack<String> restack = new Stack<>();
        while (!stack.empty()) {
            restack.push(stack.pop());
        }
        while (!restack.empty()) {
            res = res + restack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("1[a[[bc]d]]"));
    }
}
