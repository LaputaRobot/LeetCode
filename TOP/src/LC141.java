public class LC141 {
    public boolean hasCycle(ListNode head) {
        if (head==null)return false;
        if (head.next==head)return true;
        if (head.next==null) return false;
        ListNode H=head;
        ListNode hNext=head.next;
        ListNode hNN=head.next.next;
        while (true){
            hNext.next=head;
            if (head==H) head.next=null;
            head=hNext;
            hNext=hNN;
            if (hNext==null) break;
            hNN=hNext.next;
            if (hNext==H) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(0);
        ListNode node4=new ListNode(-4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
//        node4.next=node2;
        System.out.println(new LC141().hasCycle(node1));
    }
}
