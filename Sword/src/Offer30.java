import java.util.*;

class MinStack {
    private Stack<ArrayList<Integer>> stack=new Stack<ArrayList<Integer>>();
    private int min;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (stack.isEmpty()) min=x;
        else if (x<min) min=x;
        ArrayList<Integer> item=new ArrayList<Integer>();
        item.add(x);
        item.add(min);
        stack.push(item);
    }

    public void pop() {
        stack.pop();
        if (!stack.isEmpty())min=stack.peek().get(1);
    }

    public int top() {
        return  stack.peek().get(0);
    }

    public int min() {
        return  stack.peek().get(1);
    }
}

public class Offer30 {
    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(-10);
        minStack.push(14);
        minStack.push(-20);
        minStack.pop();
        minStack.push(10);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }
}
