import java.util.LinkedList;

public class lc101 {
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    // 递归法
    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    //迭代法
    public static boolean isSymmetricD(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(6, null, null), new TreeNode(3, null, null));
        root.right = new TreeNode(2, new TreeNode(3, null, null), new TreeNode(6, null, null));
        System.out.println(isSymmetricD(root));
    }
}
