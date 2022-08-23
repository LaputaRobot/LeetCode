public class Offer24 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode temp1=head.next;
        ListNode temp2 = null;
        if (temp1!=null) temp2=temp1.next;
        else return head;
        head.next=null;
        while (temp1!=temp2||temp1!=head){
            temp1.next=head;
            head=temp1;
            temp1=temp2;
            if (temp1==null) break;
            temp2=temp1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2));
        System.out.println(new Offer24().reverseList(head));
    }
}
