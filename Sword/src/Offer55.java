public class Offer55 {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public boolean isBalanced1(TreeNode root) {
        if (root==null) return true;
        return isBalanced1(root.left)&&isBalanced1(root.right)&&Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1;
    }
    public boolean isBalanced(TreeNode root) {
        return back(root)!=-1;
    }
    public int back(TreeNode root){
        if (root==null) return 0;
        int leftDepth=back(root.left);
        if (leftDepth==-1) return -1;
        int rightDepth=back(root.right);
        if (rightDepth==-1) return -1;
        return Math.abs(leftDepth-rightDepth)>1?-1:Math.max(leftDepth,rightDepth)+1;
    }
    public static void main(String[] args) {
        Object[] values=new Object[]{1,2,2,3,3,null,null,4,4};
        TreeNode root =TreeNode.getTree(values);
        System.out.println(new Offer55().isBalanced(root));
    }
}
