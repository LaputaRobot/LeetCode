import java.util.*;

class MaxQueue {
    Deque<Integer> deque=new ArrayDeque<>();
    Deque<Integer> stack=new ArrayDeque<>();
    public MaxQueue() {

    }

    public int max_value() {
        return stack.isEmpty()?-1:stack.getFirst();
    }

    public void push_back(int value) {
        deque.addLast(value);
        while (!stack.isEmpty()&&stack.getLast()<value)stack.removeLast();
        stack.addLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) return -1;
        int res=deque.removeFirst();
        if (res==stack.getFirst()) stack.removeFirst();
        return res;
    }
}

public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{5,4,4,2,1,2,3,4,5};
        MaxQueue maxQueue=new MaxQueue();
        maxQueue.push_back(5);
        maxQueue.push_back(4);
        maxQueue.push_back(3);
        maxQueue.push_back(4);
        maxQueue.push_back(1);
        System.out.println(maxQueue.max_value());
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value());
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value());
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value());
        maxQueue.pop_front();
    }
}
