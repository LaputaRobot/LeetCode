public class LC142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        do {
            if (fast == null || fast.next == null) return null;
            else {
                slow = slow.next;
                fast = fast.next.next;
            }
        } while (slow != fast);
        while (head!=slow){
            head=head.next;
            slow=slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(0);
        ListNode node4=new ListNode(-4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;
        System.out.println(new LC142().detectCycle(node1).val);
    }
}
