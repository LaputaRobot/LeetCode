package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public void sort1(int[] nums){
        for (int i = nums.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j]>nums[j+1]){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
    }
    public void sort2(int[] nums){
        int end=nums.length-1;
        while (end>0){
            int newEnd=0;
            for (int j = 0; j < end; j++) {
                if (nums[j]>nums[j+1]){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                    newEnd=j;
                }
            }
            end=newEnd;
        }
    }

    public static void main(String[] args) {
        Random random=new Random(1);
        BubbleSort bubbleSort=new BubbleSort();
        CocktailSort cocktailSort=new CocktailSort();
        InsertSort insertSort=new InsertSort();
        SelectionSort selectionSort=new SelectionSort();
        MergeSort mergeSort=new MergeSort();
        QuickSort quickSort=new QuickSort();
        int len=random.nextInt(100);
        int[] nums=new int[len];
        for (int i = 0; i < len; i++) {
            nums[i]=random.nextInt(1000);
//            nums[i]=i;
        }
//        nums[len-1]=1;
//        nums=new int[]{3,2,1};
        System.out.println(Arrays.toString(nums));
//        bubbleSort.sort1(nums);
//        bubbleSort.sort2(nums);
//        cocktailSort.sort(nums);
//        insertSort.sort1(nums);
//        selectionSort.sort(nums);
//        mergeSort.sort(nums);
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
