package free;

class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
   public TreeNode(int val) {
     this.val = val;
   }
 }
public class Qian {
    public static void main(String[] args) {

    }
    public TreeNode reConstructBST (int[] preSlice) {
        // write code here
        if (preSlice.length==0)return null;
        TreeNode head=new TreeNode(preSlice[0]);
        for (int i = 1; i < preSlice.length; i++) {
            TreeNode h=head;
            while (true) {
                if (preSlice[i] > h.val) {
                    if (h.right==null) {
                        h.right = new TreeNode(preSlice[i]);
                        break;
                    }
                    else h=h.right;
                }
                else if (preSlice[i] < h.val) {
                    if (h.left==null) {
                        h.left = new TreeNode(preSlice[i]);
                        break;
                    }
                    else h=h.left;
                }
            }
        }
        return head;
    }
}
