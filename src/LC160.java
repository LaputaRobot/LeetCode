public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null)
            return null;
        ListNode hA=headA;
        ListNode hB=headB;
        while (headA!=headB){
           headA=headA.next;
           headB=headB.next;
           if (headA==null)headA=hB;
           if (headB==null)headB=hA;
        }
        return headA;
    }
    public static void main(String[] args) {

    }
}
