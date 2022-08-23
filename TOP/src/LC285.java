public class LC285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode[] res=new TreeNode[1];
        dfs(root,p,res);
        return res[0];
    }

    public boolean dfs(TreeNode root,TreeNode p,TreeNode[] res){
        if (root.val>p.val) {
            if(dfs(root.left, p,res)){
                res[0]=root;
            }
            return false;
        }
        else {
            if (root==p){
                if (p.right==null)return true;
                else {
                    TreeNode tmp=p.right;
                    while (tmp.left!=null)tmp=tmp.left;
                    res[0]=tmp;
                    return false;
                }
            }
            return dfs(root.right, p,res);
        }
    }
    public static void main(String[] args) {
        TreeNode root=TreeNode.getTree(new Object[]{5,3,6,2,4,null,null,1});
        System.out.println(new LC285().inorderSuccessor(root,root.right));
    }
}
