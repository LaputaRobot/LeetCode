public class LC328 {
    public ListNode oddEvenList(ListNode head) {
        if (head==null) return null;
        ListNode h1=head;
        ListNode h2=head.next;
        ListNode H2=h2;
        while (h2!=null){
            h1.next=h2.next;
            if (h1.next==null)break;
            h1=h1.next;
            h2.next=h1.next;
            h2=h2.next;
        }
        h1.next=H2;
        return head;
    }

    public static void main(String[] args) {
        ListNode head=ListNode.genListByArray(new int[]{2,1,2});
        System.out.println(new LC328().oddEvenList(head));
    }
}
