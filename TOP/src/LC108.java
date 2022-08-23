public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int left,int right){
        if (left>right) return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new LC108().sortedArrayToBST(new int[]{1,2,3,4,5}));
    }
}
