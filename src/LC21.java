public class LC21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }
            else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1!=null?l1:l2;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2=new ListNode(1,new ListNode(3,new ListNode(4)));
        LC21 lc21=new LC21();
        System.out.println(l1);
        System.out.println(lc21.mergeTwoLists(l1,l2));
    }
}
