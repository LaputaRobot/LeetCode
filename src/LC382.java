import java.util.Random;

public class LC382 {
}
class Solution382 {
    ListNode listNode;
    Random random;

    public Solution382(ListNode head) {
        this.listNode=head;
        this.random=new Random();
    }

    public int getRandom() {
        ListNode node=listNode;
        int res=node.val;
        int index=1;
        while (node!=null){
            if (random.nextInt(index)==0){
                res=node.val;
            }
            index++;
            node=node.next;
        }
        return res;
    }
}