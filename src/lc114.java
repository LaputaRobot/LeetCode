public class lc114 {
    //未完成
    public static void flatten(TreeNode root) {
        myFlatten(root);
    }
    public static TreeNode myFlatten(TreeNode root){
        TreeNode lastNode=root;
        if(root.left==null&&root.right==null) return lastNode;
        if(root.left!=null) lastNode=myFlatten(root.left);
        lastNode.right=root.right;
        root.right=lastNode;
        root.left=null;
        lastNode=lastNode.right;
        if (root.right!=null) lastNode=myFlatten(root.right);
        return lastNode;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null));
        root.right = new TreeNode(5, new TreeNode(6, null, null), new TreeNode(7, null, null));
        flatten(root);
        System.out.println(root);
    }
}
