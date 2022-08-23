import java.util.LinkedList;
import java.util.Queue;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()){
            int len=queue.size();
            while (len>0){
                TreeNode tmp=queue.poll();
                TreeNode left=tmp.left;
                if (left!=null)queue.add(left);
                TreeNode right=tmp.right;
                if (right!=null)queue.add(right);
                tmp.left=right;
                tmp.right=left;
                len--;
            }
        }
        return root;
    }
}
