public class LC143 {
    public void reorderList(ListNode head) {
        if (head==null)return;
        int len=0;
        ListNode n=head;
        while (n!=null){
            len++;
            n=n.next;
        }
        n=head;
        int start=0;
        while (start<len/2-1) {
            n = n.next;
            start++;
        }
        ListNode s=n.next;
        n.next=null;
        ListNode p=null;
        while (s!=null){
            n=s.next;
            s.next=p;
            p=s;
            s=n;
        }
        ListNode h=head;
        while (p!=null){
            ListNode hN=h.next;
            ListNode pN=p.next;
            h.next=p;
            if (hN==null) {
                return;
            }
            p.next=hN;
            p=pN;
            h=hN;
        }
    }

    public static void main(String[] args) {
        LC143 lc143 = new LC143();
        ListNode listNode = ListNode.genListByArray(new int[]{1, 2, 3, 4, 5, 6,7});
        lc143.reorderList(listNode);
        System.out.println(listNode);
    }
}
