package sort;

public class CocktailSort {
    public void sort(int[] nums){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int newR=left;
            for (int i = left; i < right; i++) {
                if (nums[i]>nums[i+1]){
                    int tmp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=tmp;
                    newR=i;
                }
            }
            right=newR;
            if (left>=right) break;
            int newL=right;
            for (int i = right; i > left; i--) {
                if (nums[i]<nums[i-1]){
                    int tmp=nums[i];
                    nums[i]=nums[i-1];
                    nums[i-1]=tmp;
                    newL=i;
                }
            }
            left=newL;
        }
    }
}
