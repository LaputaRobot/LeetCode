public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null||l2==null) return l1==null?l2:l1;
        if (l1.val>l2.val){
            ListNode tmp=l1;
            l1=l2;
            l2=tmp;
        }
        ListNode res=l1;
        while (l2!=null){
            if (l1.next==null){
                l1.next=l2;
                break;
            }
            if (l2.val>=l1.val&&l2.val<l1.next.val){
                ListNode tmp=l2.next;
                l2.next=l1.next;
                l1.next=l2;
                l2=tmp;
            }
            l1=l1.next;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1=new  int[]{};
        int[] nums2=new  int[]{};
        ListNode l1=ListNode.genListByArray(nums1);
        ListNode l2=ListNode.genListByArray(nums2);
        System.out.println(new Offer25().mergeTwoLists(l1,l2));
    }
}
