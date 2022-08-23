public class LC237 {
    public void deleteNode(ListNode h,ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode h=ListNode.genListByArray(new int[]{4,5,1,9});
        new LC237().deleteNode(h,h.next);
        System.out.println(h);
    }
}
