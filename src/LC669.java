public class LC669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null)return null;
        if (root.val<low)return trimBST(root.right,low,high);
        else if(root.val>high)return trimBST(root.left,low,high);
        else {
            root.left=trimBST(root.left,low,high);
            root.right=trimBST(root.right,low,high);
            return root;
        }
    }
    public static void main(String[] args) {
        TreeNode root=TreeNode.getTree(new Object[]{8,4,12,2,6,10,13,1,3,5,7,9,11});
        System.out.println(new LC669().trimBST(root,3,9));
    }
}
