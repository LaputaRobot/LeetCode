public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left=head;
        int dis=0;
        while (head!=null){
            head=head.next;
            if (dis<k) dis++;
            else {
                left=left.next;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode().genListByArray(new int[]{4,5,1,1,9});
        System.out.println(new Offer22().getKthFromEnd(head,5));
    }
}
