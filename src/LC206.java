public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode h1=null,h2=null,h3=null;
        if (head!=null){
            h1=head;
            if (h1.next!=null) {
                h2 = h1.next;
                h1.next=null;
                if (h2.next!=null)h3=h2.next;
            }
        }
        while (h2!=null){
            h2.next=h1;
            h1=h2;
            h2=h3;
            if (h3!=null) h3=h3.next;
        }
        return h1;
    }

    public static void main(String[] args) {
        LC206 lc206 = new LC206();
//        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode l2=new ListNode(1,new ListNode(2));
        System.out.println(lc206.reverseList(l2));
    }
}
