import java.util.Arrays;
import java.util.Random;

public class LC148 {
    public ListNode sortList(ListNode head) {
        return helper(head,null);
    }
    public ListNode sortList1(ListNode head) {
        return helper1(head);
    }

    public ListNode helper(ListNode head,ListNode tail){
        if (head==null) return head;
        if (head==tail) {
            head.next=null;
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        ListNode head2=mid.next;
        mid.next=null;
        ListNode list1=helper(head,mid);
        ListNode list2=helper(head2,tail);
        return merge(list1,list2);
    }
    public ListNode helper1(ListNode head){
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode last=dummyHead;
            ListNode next=dummyHead.next;
            while (next!=null) {
                ListNode head1=next;
                ListNode flag1 = new ListNode(0,next);
                for (int i = 0; i < subLength; i++) {
                    flag1 = flag1.next;
                    if (flag1==null){
                        break;
                    }
                }
                if (flag1==null) {
                    last.next=head1;
                    break;
                }
                ListNode head2 = flag1.next;
                ListNode flag2 = flag1;
                for (int i = 0; i < subLength; i++) {
                    flag1 = flag1.next;
                    if (flag1==null) {
                        next=null;
                        break;
                    }
                }
                if (flag1!=null) {
                    next = flag1.next;
                    flag1.next = null;
                }
                flag2.next = null;
                last.next = merge(head1, head2);
                while (last.next != null) last = last.next;
            }
        }
        return dummyHead.next;
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode H=new ListNode(0);
        ListNode h=H;
        while (head1!=null&&head2!=null){
            if (head1.val>head2.val){
                h.next=head2;
                head2=head2.next;
            }else {
                    h.next=head1;
                    head1=head1.next;
            }
            h=h.next;
            h.next=null;
        }
        if (head1==null)h.next=head2;
        if (head2==null)h.next=head1;
        return H.next;
    }
    public static void main(String[] args) {
        Random random=new Random();
        int len=random.nextInt(100);
        int[] nums=new int[len];
        for (int i = 0; i < len; i++) {
            nums[i]=random.nextInt(100);
        }
//        nums=new int[]{84, 15, 44, 26, 16};
        System.out.println(Arrays.toString(nums));
        ListNode head=ListNode.genListByArray(nums);
        System.out.println(new LC148().sortList1(head));
        ListNode head1=ListNode.genListByArray(nums);
        System.out.println(new LC148().sortList(head1));
    }
}
