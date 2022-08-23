import java.util.LinkedList;
import java.util.Queue;

public class LC225 {
    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        public MyStack() {
            queue1=new LinkedList<>();
            queue2=new LinkedList<>();
        }

        public void push(int x) {
            if (queue1.size()>0)queue2.add(queue1.poll());
            queue1.add(x);
        }

        public int pop() {
            int res=queue1.poll();
            while (queue2.size()>1){
                queue1.add(queue2.poll());
            }
            Queue<Integer> tmp=queue1;
            queue1=queue2;
            queue2=tmp;
            return res;
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.size()+queue2.size()==0;
        }
    }

    public static void main(String[] args) {

    }
}
