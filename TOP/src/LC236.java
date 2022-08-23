public class LC236 {
    static TreeNode res=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p.val,q.val);
        return res;
    }
    public int helper(TreeNode root,int val1,int val2){
        if (root==null)return 0;
        int thisN=0;
        if (root.val==val1||root.val==val2)
            thisN=1;
        int left=helper(root.left,val1,val2);
        if (left==2) return 2;
        int right=helper(root.right,val1,val2);
        if (right==2) return 2;
        if (left+right+thisN==2)
            res = root;
        return left+right+thisN;
    }
    public static void main(String[] args) {
        TreeNode root=TreeNode.getTree(new Object[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p=root.left.left;
//        TreeNode q=p.right.right;
        TreeNode q=root.right.right;
        System.out.println(new LC236().lowestCommonAncestor(root,p,q));
    }
}
