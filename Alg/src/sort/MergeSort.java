package sort;

public class MergeSort {
    public void sort(int[] nums){
        helper(nums,0,nums.length-1);
    }
    public void helper(int[] nums,int left,int right){
        if (left>=right) return;
        int mid=(left+right)/2;
        helper(nums,left,mid);
        helper(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    public void merge(int[] nums,int left,int mid,int right){
        int[] tmp=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while (i<=mid||j<=right){
            if (j>right) {
                tmp[k] = nums[i];
                i++;
                k++;
                continue;
            }
            if (i>mid){
                tmp[k] = nums[j];
                j++;
                k++;
                continue;
            }
            if (i<=mid&&j<=right) {
                if (nums[i] > nums[j]) {
                    tmp[k] = nums[j];
                    j++;
                } else {
                    tmp[k] = nums[i];
                    i++;
                }
                k++;
            }

        }
        if (right - left >= 0) System.arraycopy(tmp, 0, nums, left, right - left+1);
    }
}
