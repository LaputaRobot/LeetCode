package sort;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap >>= 1) {
            for (int i = 0; i < gap; i++) {
                int j;
                for (j = i + gap; j < arr.length; j += gap) {
                    int tmp = arr[j];
                    int k=j-gap;
                    while (arr[k] > tmp) {
                        arr[k+gap] = arr[k];
                        k -= gap;
                        if (k<0)break;
                    }
                    arr[k+gap] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random=new Random();
        int len=random.nextInt(100);
        int[] nums=new int[len];
        for (int i = 0; i < len; i++) {
            nums[i]=random.nextInt(100);
        }
//        int[] nums = {84,83,88,87,61,50,70,60,80,99};
        System.out.println(Arrays.toString(nums));
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
