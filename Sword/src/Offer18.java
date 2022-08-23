public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode l=head,r=head;
        if (head==null) return head;
        if (head.val==val) return head.next;
        while (r!=null){
            if (r.val==val){
                r=r.next;
                l.next=r;
                break;
            }
            else {
                l=r;
            }
            r=r.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode().genListByArray(new int[]{4,5,1,1,9});
        System.out.println(new Offer18().deleteNode(head,1));
    }
}
