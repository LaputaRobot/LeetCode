public class Offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len=preorder.length;
        return helper(preorder,inorder,0,len-1,0,len-1);
    }
    public TreeNode helper(int[] preorder,int[] inorder,int l1,int r1,int l2,int r2){
        if (l1>r1) return null;
        TreeNode root=new TreeNode(preorder[l1]);
        int index=getIndex(inorder,l2,r2,preorder[l1]);
        int len=index-l2;
        root.left=helper(preorder,inorder,l1+1,l1+len,l2,index-1);
        root.right=helper(preorder,inorder,l1+len+1,r1,index+1,r2);
        return root;
    }
    public int getIndex(int[] nums,int left,int right,int target){
        for (int i = left; i <= right; i++) {
            if (target==nums[i]) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        System.out.println(new Offer07().buildTree(preorder,inorder));
    }
}
