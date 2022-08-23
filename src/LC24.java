public class LC24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=head;
        while (next!=null){
            head=next;
            next=head.next;
            head.next=pre;
            pre=head;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.genListByArray(new int[]{});
        LC24 lc24 = new LC24();
        System.out.println(lc24.reverseList(listNode));
    }
}
