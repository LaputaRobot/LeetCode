public class LC654 {
    public static void main(String[] args) {
        System.out.println(new LC654().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        else {
            int maxIndex = getMaxIndex(nums, start, end);
            return new TreeNode(nums[maxIndex], constructMaximumBinaryTree(nums, start, maxIndex - 1), constructMaximumBinaryTree(nums, maxIndex + 1, end));
        }
    }

    public int getMaxIndex(int[] nums, int i, int j) {
        int max=-1;
        int maxIndex=i;
        for (int k = i; k <= j; k++) {
            if (nums[k]>max){
                max=nums[k];
                maxIndex=k;
            }
        }
        return maxIndex;
    }
}
