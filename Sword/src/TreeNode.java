import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x,TreeNode left,TreeNode right) {
        val = x;
        this.left=left;
        this.right=right;
    }
    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
    public static TreeNode getTree(Object[] value) {
        if (value.length==0) return null;
        TreeNode p = new TreeNode((Integer) value[0]);
        TreeNode q = p;
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        while (p != null) {
            if (2 * i + 1 < value.length) {
                if (value[2 * i + 1] != null) {
                    p.left = new TreeNode((Integer) value[2 * i + 1]);
                    queue.add(p.left);
                }
            }
            if (2 * i + 2 < value.length) {
                if (value[2 * i + 2] != null) {
                    p.right = new TreeNode((Integer) value[2 * i + 2]);
                    queue.add(p.right);
                }
            }
            p = queue.poll();
            i += 1;
        }
        return q;
    }
}
