public class lc98 {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //递归法
    public static boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower) return false;
        if (root.val >= upper) return false;
        return isValidBST(root.right, root.val, upper) && isValidBST(root.left, lower, root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1, null, null);
        root.right = new TreeNode(4, new TreeNode(3, null, null), new TreeNode(6, null, null));
        System.out.println(isValidBST(root));
    }
}
