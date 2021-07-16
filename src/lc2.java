public class lc2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode res=head;
        int tmp1 = 0, tmp2 = 0;
        while (l1 != null || l2 != null|| tmp2!=0) {
            if (l1 != null && l2 != null) {
                if (l1.val + l2.val + tmp2 >= 10) {
                    tmp1 = (l1.val + l2.val + tmp2) % 10;
                    tmp2 = 1;
                } else {
                    tmp1 = l1.val + l2.val+tmp2;
                    tmp2=0;
                }
            } else {
                if (l1 != null) {
                    if (l1.val  + tmp2 >= 10) {
                        tmp1 = (l1.val  + tmp2) % 10;
                        tmp2 = 1;
                    } else {
                        tmp1 = l1.val +tmp2;
                        tmp2=0;
                    }
                }
                else if (l2 != null) {
                    if (l2.val  + tmp2 >= 10) {
                        tmp1 = (l2.val  + tmp2) % 10;
                        tmp2 = 1;
                    } else {
                        tmp1 = l2.val +tmp2;
                        tmp2=0;
                    }
                }
                else {
                    tmp1 = tmp2;
                    tmp2=0;
                }
            }
            res.next = new ListNode(tmp1);
            res=res.next;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1=new ListNode(2,new ListNode(4,new ListNode(6)));
        ListNode list2=new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode list3=new ListNode(0);
        ListNode list4=new ListNode(0);
        ListNode list5=new ListNode(9,new ListNode(9));
        ListNode res=addTwoNumbers(list1,list2);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }

    }
}
