import java.util.ArrayList;

class MinStack {
    /**
     * initialize your data structure here.
     */
    int capity=10;
    int[] stack = new int[capity];
    int[] minStack = new int[capity];
    int topIndex = -1;
    int minIndex = 0;
    int min;
    boolean first = true;


    public MinStack() {
    }
    public void makeSureCapity(){
        if(topIndex>capity-2){
            capity=2*capity;
            int[] newStack=new int[capity];
            int[] newMinStack=new int[capity];
            for (int i = 0; i <= topIndex; i++) {
                newStack[i]=stack[i];
                newMinStack[i]=minStack[i];
            }
            stack=newStack;
            minStack=newMinStack;
        }
    }
    public void push(int val) {
        topIndex++;
        stack[topIndex] = val;
        if (first == true) {
            min = val;
            minStack[minIndex] = 0;
            minIndex++;
            first = false;
        } else {
            if (val < min) {
                min = val;
                minStack[minIndex] = topIndex;
                minIndex++;
            }
        }
        makeSureCapity();
    }

    public void pop() {

        if (topIndex == 0) first = true;
        if (topIndex == minStack[minIndex - 1]) {
            minIndex--;
            if(minIndex>=1)
                min=stack[minStack[minIndex-1]];
        }
        topIndex--;
    }

    public int top() {
        return stack[topIndex];
    }

    public int getMin() {
        return stack[minStack[minIndex - 1]];
    }
}

public class lc155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(395);
        minStack.push(395);
        minStack.push(395);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(395);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        /*minStack.push(29);
        System.out.println(minStack.getMin());
        minStack.push(-482);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(-108);
        minStack.push(-251);
        System.out.println(minStack.getMin());*/
        /*minStack.push(-4);
        System.out.println(minStack.minStack);
        System.out.println(minStack.getMin());
        minStack.pop();
        //minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());*/
    }
}
