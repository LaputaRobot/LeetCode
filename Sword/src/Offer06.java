import java.util.Arrays;

public class Offer06 {
    public int[] reversePrint(ListNode head) {
        int len=0;
        ListNode h=head;
        while (head!=null) {
            len++;
            head=head.next;
        }
        int[] res=new int[len];
        for (int i = len-1; i >=0 ; i--) {
            res[i]=h.val;
            h=h.next;
        }
        return res;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        System.out.println(Arrays.toString(new Offer06().reversePrint(head)));
    }
}
