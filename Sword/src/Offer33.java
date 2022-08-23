import java.util.Stack;

public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] postorder={1,2,4,3,6,9,8,7,5};
        System.out.println(new Offer33().verifyPostorder(postorder));
    }
}
