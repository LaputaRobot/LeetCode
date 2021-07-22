public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static String toString(ListNode listNode) {
        String s="";
        while (listNode!=null){
            s+="{"+
                    "val=" + listNode.val +
                    '}'+"->";
            listNode=listNode.next;
        }
        return s;
    }
}
