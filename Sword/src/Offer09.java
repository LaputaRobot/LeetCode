import java.util.Stack;

class CQueue {
    private Stack<Integer> stack1=new Stack<Integer>() ;
    private Stack<Integer> stack2=new Stack<Integer>() ;
    public CQueue() {
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.empty()){
            return stack2.pop();
        }else {
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            if (!stack2.empty())
                return stack2.pop();
            else return -1;
        }
    }
}
public class Offer09 {
    public static void main(String[] args) {
        CQueue cQueue=new CQueue() ;
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(6);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
