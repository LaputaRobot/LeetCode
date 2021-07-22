public class LC876 {
    public static ListNode middleNode(ListNode head) {
        ListNode mid=head,end=head;
        int i=0;
        while (end.next!=null) {
            end = end.next;
            i++;
            if(i%2==0)
                mid=mid.next;
        }
        if (i%2==1) mid=mid.next;
        return mid;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(0,null);
        ListNode listNode=head;
        for (int i =1; i <= 6; i++) {
            listNode.next=new ListNode(i,null);
            listNode=listNode.next;
        }
        ListNode mid=middleNode(head.next);
        System.out.println(ListNode.toString(mid));
    }
}
