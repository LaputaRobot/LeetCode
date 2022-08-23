package sort;

public class InsertSort {
    public void sort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int j=i;
            while (j>0&&nums[j]<nums[j-1]){
                int tmp=nums[j];
                nums[j]=nums[j-1];
                nums[j-1]=tmp;
                j--;
            }
        }
    }
    public void sort1(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int tmp=nums[i];
            int j=i-1;
            while (j>=0&&nums[j]>tmp){
                nums[j+1]=nums[j];
                j--;
            }
            if (i!=j+1)
                nums[j+1]=tmp;
        }
    }
}
