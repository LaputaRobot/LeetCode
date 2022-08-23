public class Offer54 {
    int num=0,res;
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }
    public void dfs(TreeNode root,int k){
        if (root==null||num>=k) return ;
        dfs(root.right,k);
        num++;
        if(num==k) res = root.val;
        dfs(root.left,k);

    }
    public static void main(String[] args) {
        Object[] v=new Object[]{5,3,7,2,4,6,8,1};
        TreeNode root=TreeNode.getTree(v);
        System.out.println(new Offer54().kthLargest(root,8));
    }
}
