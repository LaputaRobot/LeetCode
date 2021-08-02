public class LC617 {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1!=null&root2!=null){
            root1.val+=root2.val;
            root1.left=mergeTrees(root1.left,root2.left);
            root1.right=mergeTrees(root1.right,root2.right);
        }
        else if (root1==null){
             return root2;
        }
        return root1;
    }
    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1),root2=new TreeNode(2);
        root1.left=new TreeNode(3,new TreeNode(5,null,null),null);
        root1.right=new TreeNode(2);
        root2.left=new TreeNode(1,null,new TreeNode(4,null,null));
        root2.right=new TreeNode(3,null,new TreeNode(7,null,null));
        root1=mergeTrees(root1,root2);
        System.out.println(root1);
    }
}
