public class LC19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head,end=head;
        int dist=0;
        while (end!=null){
            end=end.next;
            if (dist>=n+1) {
                first=first.next;
            }
            else dist++;
        }
        if (dist==n+1)
            first.next=first.next.next;
        else head=head.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(0,null);
        ListNode listNode=head;
        for (int i =1; i <= 1; i++) {
            listNode.next=new ListNode(i,null);
            listNode=listNode.next;
        }
        head=head.next;
        System.out.println(ListNode.toString(removeNthFromEnd(head,1)));
    }
}
