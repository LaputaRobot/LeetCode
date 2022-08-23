public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len;
        ListNode pre=null;
        ListNode start=head;
        ListNode H=head;
        boolean flag=false;
        while (head!=null) {
            len=0;
            while (len < k && head != null) {
                len++;
                head = head.next;
            }
            if (len < k) {
                if (pre!=null)
                    pre.next=start;
                return H;
            }
            ListNode p=null;
            ListNode n=start;
            ListNode S=start;
            while (n!=head){
                n=start.next;
                start.next=p;
                p=start;
                start=n;
            }
            if (!flag){
                H=p;
                flag=true;
            }
            else
                pre.next=p;
            pre=S;
        }
        return H;
    }

    public static void main(String[] args) {
//        ListNode listNode = ListNode.genListByArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode listNode = ListNode.genListByArray(new int[]{1,2,3});
        LC25 lc25 = new LC25();
        System.out.println(lc25.reverseKGroup(listNode,1));
    }
}
