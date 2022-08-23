import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        else {
            return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        }
    }

    public static void main(String[] args) {
        Object[] value=new Object[]{1,2,2,3,4,4,3,1,3,3,4,4,3,3,1};
        TreeNode root=TreeNode.getTree(value);
        System.out.println(new Offer28().isSymmetric(root));
    }
}
