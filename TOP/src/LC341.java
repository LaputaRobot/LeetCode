import java.util.*;

interface NestedInteger {

       // @return true if this NestedInteger holds a single integer, rather than a nested list.
       public boolean isInteger();

       // @return the single integer that this NestedInteger holds, if it holds a single integer
       // Return null if this NestedInteger holds a nested list
       public Integer getInteger();

       // @return the nested list that this NestedInteger holds, if it holds a nested list
       // Return empty list if this NestedInteger holds a single integer
       public List<NestedInteger> getList();
 }
class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> deque=new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        deque.addAll(nestedList);
    }

    @Override
    public Integer next() {
//        if (deque.peekFirst()==null)return null;
//        while (!deque.peekFirst().isInteger()){
//            Stack<NestedInteger> stack=new Stack<>();
//            for (NestedInteger n : deque.removeFirst().getList()) {
//                stack.push(n);
//            }
//            while (!stack.isEmpty()){
//                deque.addFirst(stack.pop());
//            }
//            if (deque.peekFirst()==null)return null;
//        }
        return deque.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (deque.isEmpty()) return false;
        while (!deque.peekFirst().isInteger()){
            Stack<NestedInteger> stack=new Stack<>();
            for (NestedInteger n : deque.removeFirst().getList()) {
                stack.push(n);
            }
            while (!stack.isEmpty()){
                deque.addFirst(stack.pop());
            }
            if (deque.peekFirst()==null)return false;
        }
        return !deque.isEmpty();
    }
}
public class LC341 {

}
