import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode getTree(Object[] value) {
        TreeNode p = new TreeNode((Integer) value[0]);
        TreeNode q = p;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
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

    @Override
    public String toString() {
        return "{"+ val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
