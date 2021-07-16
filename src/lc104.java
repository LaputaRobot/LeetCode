public class lc104 {
    public static int maxDepth(TreeNode root) {
        if (root==null) return 0;
        else return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(6, null, null), new TreeNode(3, null, null));
        root.right = new TreeNode(2, new TreeNode(3, null, null), new TreeNode(6, null, null));
        System.out.println(maxDepth(root));
    }
}
