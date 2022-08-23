public class Offer68 {
    TreeNode res=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
    public void dfs(TreeNode root,TreeNode p,TreeNode q){
        int min=Math.min(p.val,q.val);
        int max=Math.max(p.val,q.val);
        if (root.val>=min&&root.val<=max) res=root;
        if (res==null) {
            if (root.val>max) dfs(root.left, p, q);
            else dfs(root.right, p, q);
        }
    }
    public static void main(String[] args) {
        Object[] values=new Object[]{6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root=TreeNode.getTree(values);
        assert root != null;
        System.out.println(new Offer68().lowestCommonAncestor(root,root.left.right.right,root.right.right));
    }
}
