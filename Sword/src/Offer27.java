public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        Object[] value=new Object[]{4,2,7,1,3,6,9};
        TreeNode root =TreeNode.getTree(value);
        System.out.println(new Offer27().mirrorTree(root));
    }
}
