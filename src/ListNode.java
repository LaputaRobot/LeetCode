public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode genListByArray(int[] vals){
        if (vals.length==0) return null;
        ListNode head=new ListNode(vals[0]);
        ListNode h=head;
        for (int i = 1; i < vals.length; i++) {
            head.next= new ListNode(vals[i]);
            head=head.next;
        }
        return h;
    }
    public  String toString() {
        return ""+val+"->"+next;
    }
}
