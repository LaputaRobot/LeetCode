import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC23 {
    /**
     * 每次只要找到链表中最小的头，且后面只有一个元素发生变化，所以该方法存在很多不必要的比较
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        boolean done = false;
        ListNode H = null;
        ListNode node = H;
        while (true) {
            ListNode minNode = null;
            int minIndex = 0;
            done = true;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;
                done = false;
                if (minNode == null || minNode.val > lists[i].val) {
                    minNode = lists[i];
                    minIndex = i;
                }
            }
            if (done) break;
            if (H == null) {
                H = minNode;
                node = H;
            } else {
                node.next = minNode;
                node = node.next;
            }
            lists[minIndex] = lists[minIndex].next;
        }
        return H;
    }

    /**
     * 优先队列保存每个链表头
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode h: lists) {
            if (h!=null) queue.add(h);
        }
        ListNode H = null;
        ListNode h = H;
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            if (H == null) {
                H = minNode;
                h = minNode;
            } else {
                h.next = minNode;
                h = h.next;
            }
            if (minNode.next != null)
                queue.add(minNode.next);
        }
        return H;
    }

    public static void main(String[] args) {
        ListNode h1 = ListNode.genListByArray(new int[]{1, 4, 5});
        ListNode h2 = ListNode.genListByArray(new int[]{1, 3, 4});
        ListNode h3 = ListNode.genListByArray(new int[]{1, 2, 6});
        LC23 lc23 = new LC23();
        System.out.println(lc23.mergeKLists1(new ListNode[]{h1, h2, h3}));
    }
}
