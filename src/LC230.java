import java.util.ArrayDeque;
import java.util.Deque;

public class LC230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||stack.size()!=0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) break;
            root=root.right;
        }
        return  root.val;
    }

    public static void main(String[] args) {
        TreeNode root;
        root=TreeNode.getTree(new Object[]{3,1,4,null,2});
        System.out.println(new LC230().kthSmallest(root,4));
    }
}
