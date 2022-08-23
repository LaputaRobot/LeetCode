package sort;

public class SelectionSort {
    public void sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int index=i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j]<nums[index]) index=j;
            }
            if (i!=index){
                int tmp=nums[index];
                nums[index]=nums[i];
                nums[i]=tmp;
            }
        }
    }
}
