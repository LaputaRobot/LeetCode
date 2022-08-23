public class LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next==null) return true;
        ListNode slow=head,fast=head;
        ListNode H=head;
        boolean isDouble=false;
        while (fast!=null){
            fast=fast.next;
            isDouble=false;
            if (fast!=null) {
                isDouble=true;
                fast = fast.next;
                if (fast!=null)
                slow=slow.next;
            }
        }
        ListNode h2=slow.next;
        slow.next=null;
        ListNode h1=H;
        ListNode next=h1.next;
        if (next!=null) {
            ListNode nextN = next.next;
            h1.next = null;
            while (true) {
                next.next = h1;
                h1 = next;
                next = nextN;
                if (next == null) break;
                nextN = next.next;
            }
            if (!isDouble) {
                h1 = h1.next;
            }
        }
        while (h2!=null){
            if (h1.val!=h2.val)return false;
            h1=h1.next;
            h2=h2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode h=ListNode.genListByArray(new int[]{1,3,3,1});
        System.out.println(new LC234().isPalindrome(h));
    }
}
